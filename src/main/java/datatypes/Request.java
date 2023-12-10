package datatypes;

import interfaces.IRequest;
import interfaces.IUser;

public class Request  implements IRequest {
    private int requestNo;
    private IUser creatorUser;
    private String message;
    private int requestType;

    public Request(int requestNo, IUser creatorUser, String message, int requestType) {
        this.requestNo = requestNo;
        this.creatorUser = creatorUser;
        this.message = message;
        this.requestType = requestType;
    }

    @Override
    public int getRequestNo() {
        return this.requestNo;
    }

    @Override
    public IUser getCreatorUser() {
        return this.creatorUser;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getRequestType() {
        return this.requestType;
    }
}
