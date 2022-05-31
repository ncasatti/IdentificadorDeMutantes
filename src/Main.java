public class Main {
    public static void main(String[] args) {

        String[] testDna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        String[] testDna2 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        boolean mutant = isMutant(testDna);
        System.out.println("IsMutant: " + mutant);
    }

    private static boolean isMutant(String[] dna){

        if (isValiddDna(dna)) {
            if (checkRows(dna)) return true;
            else if (checkColumns(dna)) return true;
            else if (checkOblique(dna)) return true;
        }

        return false;
    }

    private static boolean checkRows(String[] dna){

        for (String row : dna) {

            int countColumn = 0;
            char[] charArray = row.toCharArray();

            for (int columnIndex = 0; columnIndex < charArray.length; columnIndex++) {
                int nextColumn = columnIndex + 1;
                if (nextColumn < charArray.length) {
                    if (charArray[columnIndex] == charArray[nextColumn]) {
                        countColumn++;
                        if (countColumn == 3) {
                            return true;
                        }
                    } else {
                        countColumn = 0;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkColumns(String[] dna){

        for (int columnIndex = 0; columnIndex < dna.length; columnIndex++){

            int countRow = 0;

            for (int rowIndex = 0; rowIndex < dna.length; rowIndex++){
                int nextRow = rowIndex + 1;

                if (nextRow < dna.length) {
                    if (dna[rowIndex].toCharArray()[columnIndex] == dna[nextRow].toCharArray()[columnIndex]) {
                        countRow++;
                        if (countRow == 3) {
                            return true;
                        }
                    } else {
                        countRow = 0;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkOblique(String[] dna){

        int countOblique = 0;

        for (int rowIndex = 0; rowIndex < dna.length; rowIndex++){

            int nextIndex = rowIndex + 1;

            if (nextIndex < dna.length){
                if (dna[rowIndex].toCharArray()[rowIndex] == dna[nextIndex].toCharArray()[nextIndex]){
                    countOblique++;
                    if (countOblique == 3){
                        return true;
                    }
                } else {
                    countOblique = 0;
                }
            }
        }

        return false;
    }

    private static boolean isValiddDna(String[] dna){

        for (String row: dna){
            char[] charArray = row.toCharArray();

            for (char column: charArray) {
                if (column != 'A' && column != 'T' && column != 'C' && column != 'G'){
                    return false;
                }
            }
        }

        return true;
    }

}