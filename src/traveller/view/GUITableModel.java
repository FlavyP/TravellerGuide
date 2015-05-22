package traveller.view;

import javax.swing.table.DefaultTableModel;

public class GUITableModel extends DefaultTableModel
{
   public GUITableModel(){
      super();
   }
   
   public GUITableModel(Object[] columnNames, int rowCount){
      super(columnNames, rowCount);
   }
   
   public GUITableModel(Object[][] data, Object[] columnNames){
      super(data, columnNames);
   }
   
   public boolean isCellEditable(int row, int column){
      return false;
   }
   
   public static Object[][] colCrop(Object[][] data, int colNumber){
      if (data.length > 0 && colNumber > 0 && colNumber < data[0].length){
         int rowCount = data.length;
         Object[][] result = new Object[rowCount][colNumber];
         for (int i = 0; i < rowCount; ++i){
            for (int n = 0; n < colNumber; ++n){
               result[i][n] = data[i][n];
            }
         }
         return result;
      }
      else{
         return data;
      }
   }
   
   public static Object[][] removeCol(Object[][] data, int colNumber){
      if (data.length > 0 && colNumber > -1 && colNumber < data[0].length){
         int newColCount = data[0].length-1;
         int rowCount = data.length;
         Object[][] result = new Object[rowCount][newColCount];
         for (int i = 0; i < rowCount; ++i){
            for (int n = 0; n < colNumber; ++n){
               result[i][n] = data[i][n];
            }
            for (int n = colNumber; n < (data[0].length-1); ++n){
               result[i][n] = data[i][n+1];
            }
         }
         return result;
      }
      else{
         return data;
      }
   }
}
