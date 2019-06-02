public class Main {
    public static void main(String[] args) {
        //java -jar Palindrom.jar "input.txt" "result.txt" [ parallel ] [ line ]

//        String inputFile = null;
        String inputFile = "C:\\Users\\brazh\\Desktop\\input.txt";
//        String outputFile = null;
        String outputFile = "C:\\Users\\brazh\\Desktop\\output.txt";
        boolean isParallel = false;
        boolean isLine = false;

        if(args.length<2){
            System.out.println("Set the file names!");
        } else {
            inputFile = args[0];
            outputFile = args[1];
            if(args.length<4){
                System.out.println("Additional parameters was not set!");
            } else {
                isParallel = args[2].contains("parallel");
                isLine = args[3].contains("line");
            }
        }

        PalindromeSearcher ps = new PalindromeSearcher();
        ps.searchPalindromeAndSaveToFile(inputFile,outputFile);
    }
}
