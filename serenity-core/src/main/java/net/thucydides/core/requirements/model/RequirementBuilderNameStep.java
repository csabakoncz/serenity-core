package net.thucydides.core.requirements.model;

public class RequirementBuilderNameStep {

        final String name;
        String displayName;
        String cardNumber;
        String parent;

        public RequirementBuilderNameStep(String name) {
            this.name = name;
            this.displayName = simplified(name);
        }

    private String simplified(String name) {
        return name.contains("/") ? name.substring(name.indexOf("/") + 1) : name;
    }

    public RequirementBuilderNameStep withOptionalDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public RequirementBuilderNameStep withOptionalCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public RequirementBuilderNameStep withOptionalParent(String parent) {
            this.parent = parent;
            return this;
        }

        public RequirementBuilderTypeStep withType(String type) {
            return new RequirementBuilderTypeStep(this, type);
        }

    public Requirement withTypeOf(String type) {
        return new Requirement(name, displayName, cardNumber, parent, type, new CustomFieldValue("Narrative", ""));
    }
}