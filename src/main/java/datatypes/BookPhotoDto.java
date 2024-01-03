package datatypes;

public class BookPhotoDto {
    private Long id;
    private String filename;
    private String fileType;
    private byte[] filecontent;

    public BookPhotoDto(Long id, String filename, String fileType, byte[] filecontent) {
        this.id = id;
        this.filename = filename;
        this.fileType = fileType;
        this.filecontent = filecontent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(byte[] filecontent) {
        this.filecontent = filecontent;
    }
}
