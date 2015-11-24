package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;

public class NameResource extends ResourceSupport {
    private String resourceFirstName;
    private String resourceMiddleName;
    private String resourceLastName;

    private NameResource() {}

    public NameResource(Builder builder) {
        this.resourceFirstName = builder.resourceFirstName;
        this.resourceMiddleName = builder.resourceMiddleName;
        this.resourceLastName = builder.resourceLastName;
    }

    public String getResourceFirstName() {
        return resourceFirstName;
    }

    public String getResourceMiddleName() {
        return resourceMiddleName;
    }

    public String getResourceLastName() {
        return resourceLastName;
    }

    public static class Builder {

        private String resourceFirstName;
        private String resourceMiddleName;
        private String resourceLastName;

        public Builder(String resourceLastName) {
            this.resourceLastName = resourceLastName;
        }

        public Builder firstName(String firstName) {
            this.resourceFirstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.resourceMiddleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.resourceLastName = lastName;
            return this;
        }

        public Builder copy(NameResource name) {
            this.resourceFirstName = name.resourceFirstName;
            this.resourceMiddleName = name.resourceMiddleName;
            this.resourceLastName = name.resourceLastName;
            return this;
        }

        public NameResource build() {
            return new NameResource(this);
        }

    }

    @Override
    public String toString() {
        return "Name{" +
                "resourceFirstName='" + resourceFirstName + '\'' +
                ", resourceMiddleName='" + resourceMiddleName + '\'' +
                ", resourceLastName='" + resourceLastName + '\'' +
                '}';
    }
}
