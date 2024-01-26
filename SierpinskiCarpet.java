public class SierpinskiCarpet {

   public static void main(String[] args) {
        drawSierpinskiCarpet(3, 27);
    }

    private static void drawSierpinskiCarpet(int n, int size) {

        char[][] array = new char[size][size * 2 - 1];

        for(int i = 0 ; i < size - 1 ; ++i){
            for(int j = 0 ; j < size * 2 - 1 ; ++j){
                array[i][j] = ' ';
            }
        }

        createCarpet(size, array, 0, 0, n);

        for(int i = 0 ; i < size - 1 ; ++i){
            System.out.println(array[i]);
        }

    }

    private static void createCarpet(int size, char[][] array, int row, int column, int order) {

        if(size == 1){
            array[row][column] = '*';
        }else{
            int newSize = size/order;

            for(int i = 0 ; i < order ; ++i){
                for(int j = 0 ; j < order ; ++j){

                    if(i == 1 && j == 1){
                        continue;
                    }

                    createCarpet(newSize, array, row + i * newSize, column + j * newSize, order);
                }
            }
        }

    }
}
