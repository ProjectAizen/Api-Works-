package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestRespponseBody {
    private Object meta;
    private GoRestDataPojo data;

    public GoRestRespponseBody() {
    }

    public GoRestRespponseBody(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestRespponseBody{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
