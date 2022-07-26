package sudoku.utils;

public class Command {
    private String isMultiThread;
    private String filename;

    public Command() {}

    public boolean commandIsValid(String[] args){
        if(args.length != 3) return false;
        if(args[0].equals(Constant.MULTITHREAD_COMMAND) &&
                (args[1].equals(Constant.IDENTIFIER_MULTITHREAD) || args[1].equals(Constant.IDENTIFIER_SINGLETHREAD)) &&
                (args[2].equals(Constant.FILE_NAME_1) || args[2].equals(Constant.FILE_NAME_2))
        ){
            this.isMultiThread = args[1];
            this.filename = args[2];
            return true;
        }
        return false;
    }

    public String getFilename(){ return filename; }

    public String getIsMultiThread(){ return isMultiThread; }
}
