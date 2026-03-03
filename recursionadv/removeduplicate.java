package recursionadv;

public class removeduplicate {
    public static void remDup(String str , int idx , StringBuilder newStr , boolean map[]){
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a']== true){
                    //duplicate
                    remDup(str, idx+1, newStr, map);
        }
        else{
            //not duplicate
            map[currChar - 'a']= true;
            remDup(str , idx+1, newStr.append(currChar),map);

        }
    }
        public static void main(String args[]){
            String str = "apnacollege";
            remDup(str , 0 , new StringBuilder(""), new boolean[26]);
        }
    
}



// package recursionadv;

// public class removeduplicate {

//     public static void remDup(String str, int idx, StringBuilder newStr, boolean map[]) {

//         if (idx == str.length()) {
//             System.out.println(newStr);
//             return;
//         }

//         char currChar = str.charAt(idx);

//         // ignore spaces or non-lowercase letters
//         if (currChar == ' ') {
//             remDup(str, idx + 1, newStr, map);
//             return;
//         }

//         if (map[currChar - 'a'] == true) {
//             // duplicate
//             remDup(str, idx + 1, newStr, map);
//         } else {
//             // not duplicate
//             map[currChar - 'a'] = true;
//             remDup(str, idx + 1, newStr.append(currChar), map);
//         }
//     }

//     public static void main(String args[]) {
//         String str = "apna college";
//         remDup(str, 0, new StringBuilder(""), new boolean[26]);
//     }
// }