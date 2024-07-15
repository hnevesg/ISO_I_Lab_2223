package persistencia;

import java.util.HashMap;
import java.util.Map;

public class Row {

	private Map<String, Object> attributes = new HashMap<>();

	public void addAttribute(String columnLabel, Object obj) {
		attributes.put(columnLabel, obj);
	}

	public long getLong(String columnLabel) {
		return (long) getObject(columnLabel);
	}
	public double getDouble(String columnLabel) {
		return (double) getObject(columnLabel);
	}

	public int getInt(String columnLabel) {
		int val;
		try {
			val = (int) getObject(columnLabel);
		} catch (ClassCastException e) {
			val = (int) getLong(columnLabel);
		}
		return val;
	}

	public Object getObject(String columnLabel) {
		if (attributes.containsKey(columnLabel)) {
			return attributes.get(columnLabel);
		}
		throw new RuntimeException(columnLabel + " is not a valid attribute name");
	}

	public String getString(String columnLabel) {
		return String.valueOf(getObject(columnLabel));
	}

	public boolean getBoolean(String columnLabel) {
		return getInt(columnLabel) == 1;
	}

}
