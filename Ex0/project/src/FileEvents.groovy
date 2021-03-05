import groovy.io.FileType
public  class FileEvents {



    static writeLine(String line, String filePath){

    }

    static createFile(String txt, String filePath){
        def newFile = new File(filePath )
        newFile.text=txt
        newFile.createNewFile()
    }

    static FileData readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<String>()
        File file = new File(filePath)
        def line
        file.withReader { reader ->
            while ((line = reader.readLine()) != null) {
                lines << line
                //lines.add(line)
            }
        }
        return new FileData(filePath, file, lines)
    }

    static String getFolderName(String path){
        def dir = new File(path)
        //get last folder name from path
        def folderName = dir.getAbsoluteFile().getName()

        return folderName
    }

    static ArrayList<File> getFilesInFolder(String path, String ext = ""){
        ArrayList<File> files = new  ArrayList<File>();
        def dir = new File(path)
        dir.eachFileRecurse (FileType.FILES) { file ->
              def matcher = (file.name =~ /[^\.]*$/)
            if (matcher.size() > 0 ) {
                if(ext){
                    if(matcher[0]==ext){
                        files << file
                    }
                }else{
                    files << file
                }
            }
        }
        return files
    }
}

public class FileData {
    public String path
    public File file;
    public ArrayList<String> lines

    FileData(String path, File file, ArrayList<String> lines) {
        this.path = path
        this.file = file
        this.lines = lines
    }

    def getFileName(){
        return file.getName()
    }

    def getNameWithoutExtension() {
        //return file.getName()-".vm"
        def filename = getFileName()
        return filename[0..<filename.lastIndexOf('.')]
    }
}
