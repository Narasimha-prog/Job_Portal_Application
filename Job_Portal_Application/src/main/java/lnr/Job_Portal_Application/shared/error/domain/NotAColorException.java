package lnr.Job_Portal_Application.shared.error.domain;

public class NotAColorException extends AssertionException {

    public NotAColorException(String field, String message) {
        super(field, message);
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NOT_A_COLOR;
    }
}
