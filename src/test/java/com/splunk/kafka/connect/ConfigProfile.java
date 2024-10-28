package com.splunk.kafka.connect;

import java.util.HashMap;
import java.util.Map;

public class ConfigProfile {
    private String topics;
    private String topicsRegex;
    private String token;
    private String uri;
    private boolean raw;
    private boolean ack;
    private String indexes;
    private String sourcetypes;
    private String sources;
    private boolean httpKeepAlive;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean validateCertificates;
    private boolean hasTrustStorePath;
    private String trustStorePath;
    private String trustStoreType;
    private String trustStorePassword;
    private int eventBatchTimeout;
    private int ackPollInterval;
    private int ackPollThreads;
    private int maxHttpConnPerChannel;
    private int totalHecChannels;
    private int socketTimeout;
    private String enrichements;
    private Map<String, String> enrichementMap;
    private boolean trackData;
    private int maxBatchSize;
    private int numOfThreads;
    private boolean headerSupport;
    private boolean hecFormatted;
    private String headerCustom;
    private String headerIndex;
    private String headerSource;
    private String headerSourcetype;
    private String headerHost;
    private String lineBreaker;

    public ConfigProfile() {
        this(0);
    }

    public ConfigProfile(int profile) {
        switch (profile) {
            case 0:  buildProfileDefault();
                     break;
            case 1:  buildProfileOne();
                     break;
            case 2:  buildProfileTwo();
                     break;
            case 3:  buildProfileThree();
                     break;
            case 4:  buildProfileFour();
                     break;
            default: buildProfileDefault();
                     break;
        }
    }

    /* Default Profile:
        - JSON Endpoint
        - With Ack
        - With Truststore
    */
    public ConfigProfile buildProfileDefault() {
        this.topics = "mytopic";
        this.token = "mytoken";
        this.uri = "https://dummy:8088";
        this.raw = false;
        this.ack = true;
        this.indexes = "";
        this.sourcetypes = "";
        this.sources = "";
        this.httpKeepAlive = true;
        this.httpProxyHost = "proxy.host";
        this.httpProxyPort = 8080;
        this.validateCertificates = true;
        this.hasTrustStorePath = true;
        this.trustStorePath = "./src/test/resources/keystoretest.jks";
        this.trustStoreType = "JKS";
        this.trustStorePassword = "Notchangeme";
        this.eventBatchTimeout = 1;
        this.ackPollInterval = 1;
        this.ackPollThreads = 1;
        this.maxHttpConnPerChannel = 1;
        this.totalHecChannels = 1;
        this.socketTimeout = 1;
        this.enrichements = "ni=hao,hello=world";
        this.enrichementMap = new HashMap<>();
        this.trackData = true;
        this.maxBatchSize = 1;
        this.numOfThreads = 1;
        this.lineBreaker = "\n";
        return this;
    }

    /*  Profile One:
        - Raw Endpoint
        - No Ack
        - With Trust Store
    */
    public ConfigProfile buildProfileOne() {
        this.topics = "kafka-data";
        this.token = "mytoken";
        this.uri = "https://dummy:8088";
        this.raw = true;
        this.ack = false;
        this.indexes = "index-1";
        this.sourcetypes = "kafka-data";
        this.sources = "kafka-connect";
        this.httpKeepAlive = true;
        this.validateCertificates = true;
        this.hasTrustStorePath = true;
        this.trustStorePath = "./src/test/resources/keystoretest.p12";
        this.trustStoreType = "PKCS12";
        this.trustStorePassword = "Notchangeme";
        this.eventBatchTimeout = 1;
        this.ackPollInterval = 1;
        this.ackPollThreads = 1;
        this.maxHttpConnPerChannel = 1;
        this.totalHecChannels = 1;
        this.socketTimeout = 1;
        this.enrichements = "hello=world";
        this.enrichementMap = new HashMap<>();
        this.trackData = false;
        this.maxBatchSize = 1;
        this.numOfThreads = 1;
        return this;
    }

    /*
        Profile Two:
        - Raw Endpoint
        - No Ack
        - No Trust Store
    */
    public ConfigProfile buildProfileTwo() {
        this.topics = "kafka-data";
        this.token = "mytoken";
        this.uri = "https://dummy:8088";
        this.raw = true;
        this.ack = false;
        this.indexes = "index-1";
        this.sourcetypes = "kafka-data";
        this.sources = "kafka-connect";
        this.httpKeepAlive = true;
        this.validateCertificates = false;
        this.eventBatchTimeout = 1;
        this.ackPollInterval = 1;
        this.ackPollThreads = 1;
        this.maxHttpConnPerChannel = 1;
        this.totalHecChannels = 1;
        this.socketTimeout = 1;
        this.enrichements = "hello=world";
        this.enrichementMap = new HashMap<>();
        this.trackData = false;
        this.maxBatchSize = 1;
        this.numOfThreads = 1;
        return this;
    }

    public ConfigProfile buildProfileThree() {
        this.topics = "kafka-data";
        this.token = "mytoken";
        this.uri = "https://dummy:8088";
        this.raw = true;
        this.ack = false;
        this.indexes = "index-1";
        this.sourcetypes = "kafka-data";
        this.sources = "kafka-connect";
        this.httpKeepAlive = true;
        this.validateCertificates = false;
        this.eventBatchTimeout = 1;
        this.ackPollInterval = 1;
        this.ackPollThreads = 1;
        this.maxHttpConnPerChannel = 1;
        this.totalHecChannels = 1;
        this.socketTimeout = 1;
        this.enrichements = "hello=world";
        this.enrichementMap = new HashMap<>();
        this.trackData = false;
        this.maxBatchSize = 1;
        this.numOfThreads = 1;
        this.headerSupport = true;
        this.headerIndex = "splunk.header.index";
        this.headerSource = "splunk.header.source";
        this.headerSourcetype = "splunk.header.sourcetype";
        this.headerHost = "splunk.header.host";

        return this;
    }

    /*
        Profile Four:
        - Raw Endpoint
        - with topics.regex
    */
    public ConfigProfile buildProfileFour() {
        this.topicsRegex = "^kafka-data[0-9]$";
        this.token = "mytoken";
        this.uri = "https://dummy:8088";
        this.raw = true;
        this.ack = false;
        this.indexes = "index-1";
        this.sourcetypes = "kafka-data";
        this.sources = "kafka-connect";
        this.httpKeepAlive = true;
        this.validateCertificates = false;
        this.eventBatchTimeout = 1;
        this.ackPollInterval = 1;
        this.ackPollThreads = 1;
        this.maxHttpConnPerChannel = 1;
        this.totalHecChannels = 1;
        this.socketTimeout = 1;
        this.enrichements = "hello=world";
        this.enrichementMap = new HashMap<>();
        this.trackData = false;
        this.maxBatchSize = 1;
        this.numOfThreads = 1;
        this.headerSupport = true;
        this.headerIndex = "splunk.header.index";
        this.headerSource = "splunk.header.source";
        this.headerSourcetype = "splunk.header.sourcetype";
        this.headerHost = "splunk.header.host";

        return this;
    }

    public String getLineBreaker() {
        return lineBreaker;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getTopicsRegex() {
        return topicsRegex;
    }

    public void setTopicsRegex(String topicsRegex) {
        this.topicsRegex = topicsRegex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean isRaw() {
        return raw;
    }

    public void setRaw(boolean raw) {
        this.raw = raw;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getSourcetypes() {
        return sourcetypes;
    }

    public void setSourcetypes(String sourcetypes) {
        this.sourcetypes = sourcetypes;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public boolean isHttpKeepAlive() {
        return httpKeepAlive;
    }

    public void setHttpKeepAlive(boolean httpKeepAlive) {
        this.httpKeepAlive = httpKeepAlive;
    }

    public int getHttpProxyPort() {
        return httpProxyPort;
    }

    public String getHttpProxyHost() {
        return httpProxyHost;
    }

    public void setHttpProxyHost(final String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    public void setHttpProxyPort(final int httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }

    public boolean isValidateCertificates() {
        return validateCertificates;
    }

    public void setValidateCertificates(boolean validateCertificates) {
        this.validateCertificates = validateCertificates;
    }

    public boolean isHasTrustStorePath() {
        return hasTrustStorePath;
    }

    public void setHasTrustStorePath(boolean hasTrustStorePath) {
        this.hasTrustStorePath = hasTrustStorePath;
    }

    public String getTrustStorePath() {
        return trustStorePath;
    }

    public void setTrustStorePath(String trustStorePath) {
        this.trustStorePath = trustStorePath;
    }

    public String getTrustStoreType() {
        return trustStoreType;
    }

    public void setTrustStoreType(String trustStoreType) {
        this.trustStoreType = trustStoreType;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public int getEventBatchTimeout() {
        return eventBatchTimeout;
    }

    public void setEventBatchTimeout(int eventBatchTimeout) {
        this.eventBatchTimeout = eventBatchTimeout;
    }

    public int getAckPollInterval() {
        return ackPollInterval;
    }

    public void setAckPollInterval(int ackPollInterval) {
        this.ackPollInterval = ackPollInterval;
    }

    public int getAckPollThreads() {
        return ackPollThreads;
    }

    public void setAckPollThreads(int ackPollThreads) {
        this.ackPollThreads = ackPollThreads;
    }

    public int getMaxHttpConnPerChannel() {
        return maxHttpConnPerChannel;
    }

    public void setMaxHttpConnPerChannel(int maxHttpConnPerChannel) {
        this.maxHttpConnPerChannel = maxHttpConnPerChannel;
    }

    public int getTotalHecChannels() {
        return totalHecChannels;
    }

    public void setTotalHecChannels(int totalHecChannels) {
        this.totalHecChannels = totalHecChannels;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getEnrichements() {
        return enrichements;
    }

    public void setEnrichements(String enrichements) {
        this.enrichements = enrichements;
    }

    public Map<String, String> getEnrichementMap() {
        return enrichementMap;
    }

    public void setEnrichementMap(Map<String, String> enrichementMap) {
        this.enrichementMap = enrichementMap;
    }

    public boolean isTrackData() {
        return trackData;
    }

    public void setTrackData(boolean trackData) {
        this.trackData = trackData;
    }

    public int getMaxBatchSize() {
        return maxBatchSize;
    }

    public void setMaxBatchSize(int maxBatchSize) {
        this.maxBatchSize = maxBatchSize;
    }

    public int getNumOfThreads() {
        return numOfThreads;
    }

    public void setNumOfThreads(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }

    public String getHeaderIndex() {
        return headerIndex;
    }

    public void setHeaderIndex(String headerIndex) {
        this.headerIndex = headerIndex;
    }

    public String getHeaderSource() {
        return headerSource;
    }

    public void setHeaderSource(String headerSource) {
        this.headerSource = headerSource;
    }

    public String getHeaderSourcetype() {
        return headerSourcetype;
    }

    public void setHeaderSourcetype(String headerSourcetype) {
        this.headerSourcetype = headerSourcetype;
    }

    public String getHeaderHost() {
        return headerHost;
    }

    public void setHeaderHost(String headerHost) {
        this.headerHost = headerHost;
    }

    @Override public String toString() {
        return "ConfigProfile{" + "topics='" + topics + '\'' + ", topics.regex='" + topicsRegex +  '\'' + ", token='" + token + '\'' + ", uri='" + uri + '\'' + ", raw=" + raw + ", ack=" + ack + ", indexes='" + indexes + '\'' + ", sourcetypes='" + sourcetypes + '\'' + ", sources='" + sources + '\'' + ", httpKeepAlive=" + httpKeepAlive + ", httpProxyHost=" + httpProxyHost + ", httpProxyPort=" + httpProxyPort + ", validateCertificates=" + validateCertificates + ", hasTrustStorePath=" + hasTrustStorePath + ", trustStorePath='" + trustStorePath + '\'' + ", " + "trustStoreType='" + trustStoreType + '\'' + ", trustStorePassword='" + trustStorePassword + '\'' + ", eventBatchTimeout=" + eventBatchTimeout + ", ackPollInterval=" + ackPollInterval + ", ackPollThreads=" + ackPollThreads + ", maxHttpConnPerChannel=" + maxHttpConnPerChannel + ", totalHecChannels=" + totalHecChannels + ", socketTimeout=" + socketTimeout + ", enrichements='" + enrichements + '\'' + ", enrichementMap=" + enrichementMap + ", trackData=" + trackData + ", maxBatchSize=" + maxBatchSize + ", numOfThreads=" + numOfThreads + '}';
    }
}
