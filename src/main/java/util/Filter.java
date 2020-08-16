package util;

import java.io.Serializable;

/**
 * @author Vinicius Pedro da Silveira
 */

public class Filter implements Serializable {

	private static final long serialVersionUID = -6037045234637359070L;

	private int firstRecord;

	private int amountRecords;

	private String propertyOrder;

	private boolean ascendant;

	public int getFirstRecord() {
		return firstRecord;
	}

	public void setFirstRecord(int firstRecord) {
		this.firstRecord = firstRecord;
	}

	public int getAmountRecords() {
		return amountRecords;
	}

	public void setAmountRecords(int amountRecords) {
		this.amountRecords = amountRecords;
	}

	public String getPropertyOrder() {
		return propertyOrder;
	}

	public void setPropertyOrder(String propertyOrder) {
		this.propertyOrder = propertyOrder;
	}

	public boolean isAscendant() {
		return ascendant;
	}

	public void setAscendant(boolean ascendant) {
		this.ascendant = ascendant;
	}
}
