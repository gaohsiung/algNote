public class FreshPromotion {
    public static int isPromotion(String[][] codeList, String[] shoppingCart) {
        // c.c.
        if (codeList == null || codeList.length == 0) {
            return 1;
        }
        if (shoppingCart == null || shoppingCart.length == 0) {
            return 0;
        }
        // initial
        int curCodeListIdx = 0;
        int curCartIdx = 0;
        boolean flag; // detect if the code is matching; true: curCodeList++
        // check the entire code list
        while (curCodeListIdx < codeList.length && 
            curCartIdx + codeList[curCodeListIdx].length <= shoppingCart.length) {
            flag = true;
            // check every code is matching accordingly
            for (int i = 0; i < codeList[curCodeListIdx].length; i++) { // string codeList[curCodeListIdx][i]
                if (!codeList[curCodeListIdx][i].equals("anything") 
                    && !shoppingCart[curCartIdx+i].equals(codeList[curCodeListIdx][i])) {
                    flag = false;
                    break;
                }
            }
            // move two pointers based on flag
            if (flag) {
                curCartIdx = curCartIdx + codeList[curCodeListIdx].length;
                curCodeListIdx++;
            } else {
                curCartIdx++;
            }
        }
        if (curCodeListIdx == codeList.length) { // check all the code list
            return 1;
        } else { // not check all the list
            return 0;
        }
    }
    public static void test(String[][] codeList, String[] shoppingCart, int expect) {
        System.out.println(isPromotion(codeList, shoppingCart) == expect);
    }

    public static void main(String[] args) {
        // test cases
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        // test
        test(codeList1, shoppingCart1, 1);
        test(codeList2, shoppingCart2, 0);
        test(codeList3, shoppingCart3, 0);
        test(codeList4, shoppingCart4, 0);
        test(codeList5, shoppingCart5, 1);
        test(codeList6, shoppingCart6, 1);
        test(codeList7, shoppingCart7, 1);
        test(codeList8, shoppingCart8, 1);
        test(codeList9, shoppingCart9, 1);
    }
}