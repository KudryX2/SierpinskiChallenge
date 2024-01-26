public class SierpinskiTriangle {
    public static void main(String[] args) {
        drawTriangle(4);
        drawSierpinskiTriangle(3);
    }
    public static void drawTriangle(int height){

        for(int row = 0 ; row < height - 1 ; ++row){
            StringBuilder outputLine = new StringBuilder(new String(new char[height * 2]).replace('\0', ' '));
            if(row == 0){
                outputLine.replace(height, height+1, "*");
            }else{
                outputLine.replace(height-row, height-row+1, "*");
                outputLine.replace(height+row, height+row+1, "*");
            }

            System.out.println(outputLine);
        }

        System.out.println(" " + new String(new char[(height * 2) - 1]).replace('\0', '*'));

    };

    public static void drawSierpinskiTriangle(int order) {
        int size = (int) (Math.pow(2, order + 1) - 1);
        char[][] array = new char[size][size * 2 - 1];

        for(int i = 0 ; i < size - 1 ; ++i){
            for(int j = 0 ; j < size * 2 - 1 ; ++j){
                array[i][j] = ' ';
            }
        }

        createTriangle(size, array, 0, size - 1);

        for(int i = 0 ; i < size - 1 ; ++i){
            System.out.println(array[i]);
        }
    }

    private static void createTriangle(int size, char[][] array, int row, int column) {

        if(size == 1){
            array[row][column] = '*';
        }else{
            int newSize = size/2;

            createTriangle(newSize, array, row, column);
            createTriangle(newSize, array, row + newSize, column - newSize);
            createTriangle(newSize, array, row + newSize, column + newSize);
        }

    }

}
