package ca.hank.forclass1;

public interface HttpURLConnectionPostProcessorInterface {
    void  successHandler(String dataInXML);
    void  failureHandler(Exception exception);
}
