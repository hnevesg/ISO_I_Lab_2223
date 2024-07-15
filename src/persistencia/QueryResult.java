package persistencia;

import java.util.ArrayList;
import java.util.List;

public class QueryResult {
	private List<Row> records;

	public QueryResult() {
		records = new ArrayList<>();
	}

	public QueryResult(int initialCapacity) {
		records = new ArrayList<>(initialCapacity);
	}

	public boolean isEmpty() {
		// Asumiendo es Agente el único que genera instancias de esta clase
		return records.size() == 0;
	}

	public List<Row> getRecords() {
		return records;
	}

	public Row getRow(int rowNum) {
		return records.get(rowNum - 1);
	}

	public void addAttribute(String attributeLabel, Object value) {
		records.get(records.size() - 1).addAttribute(attributeLabel, value);
	}

	public void insertRow() {
		records.add(new Row());
	}

}
