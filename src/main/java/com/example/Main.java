package com.example;

import com.example.dao.entity.tables.daos.CustomerInfoTblDao;
import com.example.dao.entity.tables.daos.CustomerTblDao;
import com.example.dao.entity.tables.pojos.CustomerInfoTbl;
import com.example.dao.entity.tables.pojos.CustomerTbl;
import com.example.xml.Customer;
import com.example.xml.Customers;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by asales on 23/1/2016.
 */
@Component
public class Main {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
    @Autowired
    private CustomerTblDao customerTblDao;
    @Autowired
    private CustomerInfoTblDao customerInfoTblDao;

    /**
     * Main Class of the app
     *
     * It will show the initial data of customer table
     *
     * Adds Single customer based from xml and persist it into database.
     *
     * Adds Multiple customers based from xml and persist it into database.
     *
     * Shows the data information after inserting the customers.
     */
    public void run() {
        intermission("****************************** RUNNING APP ******************************************");


        logger.info(customerTblDao.findAll().toString());
        logger.info(customerInfoTblDao.findAll().toString());


        addSingleCustomer();
        addMultipleCustomers();

        logger.info(customerTblDao.findAll().toString());
        logger.info(customerInfoTblDao.findAll().toString());


        intermission("****************************** APP HAS ENDED ****************************************");
    }

    private void addMultipleCustomers() {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("customers", Customers.class);
        xStream.alias("customer", Customer.class);
        xStream.addImplicitCollection(Customers.class, "customers");
        xStream.aliasField("customer", Map.class, "other");
        xStream.registerConverter(new MapEntryConverter());
        Customers map2 = (Customers) xStream.fromXML(this.getClass().getClassLoader().getResourceAsStream("customers.xml"));
        logger.info("map2: " + map2.toString());

        for (Customer customer : map2.getCustomers()) {
            insertCustomerInfos(customer,  insertCustomer(customer));
        }
    }

    private void addSingleCustomer() {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("customer", Customer.class);
        xStream.aliasField("customer", Map.class, "other");
        xStream.registerConverter(new MapEntryConverter());
        Customer map1 = (Customer) xStream.fromXML(this.getClass().getClassLoader().getResourceAsStream("customer.xml"));
        logger.info("map1: " + map1.toString());

        insertCustomerInfos(map1, insertCustomer(map1));
    }

    private CustomerTbl insertCustomer(Customer map1) {
        final CustomerTbl customerTbl = new CustomerTbl(UUID.randomUUID().toString(), map1.getName(), map1.getAge());
        customerTblDao.insert(customerTbl);
        return customerTbl;
    }

    private void insertCustomerInfos(Customer customerXmlResult, CustomerTbl customerTbl) {
        final Map<String, Object> other = customerXmlResult.getOther();
        List<CustomerInfoTbl> customerInfos = new ArrayList<>();
        for (String key : other.keySet()) {
            customerInfos.add(new CustomerInfoTbl(customerTbl.getGuid(), key.toUpperCase(), other.get(key).toString()));
        }
        customerInfoTblDao.insert(customerInfos);
    }

    private class MapEntryConverter implements Converter {
        public boolean canConvert(final Class clazz)
        {
            return AbstractMap.class.isAssignableFrom(clazz);
        }

        public void marshal(final Object value, final HierarchicalStreamWriter writer, final MarshallingContext context)
        {
            final AbstractMap<String, String> map = (AbstractMap<String, String>) value;
            for (final Map.Entry<String, String> entry : map.entrySet())
            {
                writer.startNode(entry.getKey().toString());
                writer.setValue(entry.getValue().toString());
                writer.endNode();
            }
        }

        public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context)
        {
            final Map<String, String> map = new HashMap<String, String>();
            while (reader.hasMoreChildren())
            {
                reader.moveDown();
                map.put(reader.getNodeName(), reader.getValue());
                reader.moveUp();
            }
            return map;
        }
    }

    private void intermission(String x3) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("*************************************************************************************");
        System.out.println(x3);
        System.out.println("*************************************************************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
