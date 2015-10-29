package Netflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Cell {
    String value;
    Cell reference;
    ArrayList<Cell> children;
    
    public Cell(String value){
        this.value = value;
        children = new ArrayList<Cell>();
    }
}

public class SpreadSheet {
    
    private static final int MAX_CELL_INDEX = 65000;
    private Map<Integer, Map<Integer, Cell>> data = new HashMap<Integer, Map<Integer, Cell>>();
    
    public void setValue(int row, int column, String value) {
        Map<Integer, Cell> columnMap = data.get(row);
        if(columnMap == null) {
            columnMap = new HashMap<Integer, Cell>();
            columnMap.put(column, new Cell(value));
        }
        columnMap.get(column).value = value;
    }
    
    public String getValue(int row, int column) {
        Map<Integer, Cell> columnMap = data.get(row);
        if(columnMap != null) {
            return columnMap.get(column).value;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
