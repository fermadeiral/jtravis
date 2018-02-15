package fr.inria.jtravis;

import fr.inria.jtravis.helpers.GenericHelper;

public class JTravis {

    private static JTravis instance;
    private String travisEndpoint;

    private JTravis() {
        this.travisEndpoint = GenericHelper.TRAVIS_API_ENDPOINT;
    }

    public static JTravis getInstance() {
        if (instance == null) {
            instance = new JTravis();
        }
        return instance;
    }

    public String getTravisEndpoint() {
        return travisEndpoint;
    }

    public void setTravisEndpoint(String travisEndpoint) {
        this.travisEndpoint = travisEndpoint;
    }
}
