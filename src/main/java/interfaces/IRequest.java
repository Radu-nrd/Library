package interfaces;

public interface IRequest {
    int getRequestNo();
    IUser getCreatorUser();
    String getMessage();
    int getRequestType();
}
