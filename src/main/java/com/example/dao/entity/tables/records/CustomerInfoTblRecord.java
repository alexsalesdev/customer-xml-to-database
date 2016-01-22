/**
 * This class is generated by jOOQ
 */
package com.example.dao.entity.tables.records;


import com.example.dao.entity.tables.CustomerInfoTbl;

import javax.annotation.Generated;
import javax.persistence.*;

import com.example.dao.entity.tables.pojos.CustomerInfoKey;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "CUSTOMER_INFO_TBL", schema = "PUBLIC", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"CUSTOMER_ID", "KEY"})
})
@IdClass(CustomerInfoKey.class)
public class CustomerInfoTblRecord extends UpdatableRecordImpl<CustomerInfoTblRecord> implements Record3<String, String, String> {

	private static final long serialVersionUID = 1585798712;

	/**
	 * Setter for <code>PUBLIC.CUSTOMER_INFO_TBL.CUSTOMER_ID</code>.
	 */
	public void setCustomerId(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>PUBLIC.CUSTOMER_INFO_TBL.CUSTOMER_ID</code>.
	 */
	@Id
	@Column(name = "CUSTOMER_ID", nullable = false, length = 100)
	public String getCustomerId() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.CUSTOMER_INFO_TBL.KEY</code>.
	 */
	public void setKey(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>PUBLIC.CUSTOMER_INFO_TBL.KEY</code>.
	 */
	@Id
	@Column(name = "KEY", nullable = false, length = 100)
	public String getKey() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>PUBLIC.CUSTOMER_INFO_TBL.VAL</code>.
	 */
	public void setVal(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>PUBLIC.CUSTOMER_INFO_TBL.VAL</code>.
	 */
	@Column(name = "VAL", nullable = false, length = 100)
	public String getVal() {
		return (String) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record2<String, String> key() {
		return (Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<String, String, String> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<String, String, String> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return CustomerInfoTbl.CUSTOMER_INFO_TBL.CUSTOMER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return CustomerInfoTbl.CUSTOMER_INFO_TBL.KEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return CustomerInfoTbl.CUSTOMER_INFO_TBL.VAL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getCustomerId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getKey();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getVal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerInfoTblRecord value1(String value) {
		setCustomerId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerInfoTblRecord value2(String value) {
		setKey(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerInfoTblRecord value3(String value) {
		setVal(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerInfoTblRecord values(String value1, String value2, String value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CustomerInfoTblRecord
	 */
	public CustomerInfoTblRecord() {
		super(CustomerInfoTbl.CUSTOMER_INFO_TBL);
	}

	/**
	 * Create a detached, initialised CustomerInfoTblRecord
	 */
	public CustomerInfoTblRecord(String customerId, String key, String val) {
		super(CustomerInfoTbl.CUSTOMER_INFO_TBL);

		setValue(0, customerId);
		setValue(1, key);
		setValue(2, val);
	}
}