int rowCount = 1;        int colCount = 0;        for (int i = 0; i < matrixAsString.length(); i++) {            if (matrixAsString.charAt(i) != ' ') {                colCount++;                if (Character.isISOControl(matrixAsString.charAt(i))) {                    rowCount++;                    colCount = 0;                }            }        }        this.rowCount = rowCount;        this.colCount = colCount;        int i = 0;        this.matrix = new int[rowCount][colCount];        for (int row = 0; row < rowCount; row++) {            for (int col = 0; col < colCount; col++) {                while (i <= matrixAsString.length()) {                    if (matrixAsString.charAt(i) != ' ' && !Character.isISOControl(matrixAsString.charAt(i))) {                        this.matrix[row][col] = Character.getNumericValue(matrixAsString.charAt(i));                        i++;                        break;                    } else {                        i++;                    }                }            }        }