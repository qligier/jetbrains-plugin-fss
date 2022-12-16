// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class MetadataPolicy {

    public static final MetadataPolicy NONE = new MetadataPolicy(Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN);
    public static final MetadataPolicy SSS = new MetadataPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN);
    public static final MetadataPolicy SSSO = new MetadataPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                 Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN);
    public static final MetadataPolicy SSSR = new MetadataPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                 Cardinality.OPTIONAL, Cardinality.REQUIRED,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN);
    public static final MetadataPolicy SSRO = new MetadataPolicy(Cardinality.FORBIDDEN, Cardinality.OPTIONAL,
                                                                 Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                                 Cardinality.REQUIRED, Cardinality.OPTIONAL,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN);
    public static final MetadataPolicy RROO = new MetadataPolicy(Cardinality.FORBIDDEN, Cardinality.REQUIRED,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                 Cardinality.REQUIRED, Cardinality.OPTIONAL,
                                                                 Cardinality.OPTIONAL);
    public static final MetadataPolicy SSSRR = new MetadataPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                  Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                                  Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                  Cardinality.REQUIRED, Cardinality.REQUIRED,
                                                                  Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                  Cardinality.FORBIDDEN);
    private final Cardinality id;
    private final Cardinality description;
    private final Cardinality title;
    private final Cardinality parent;
    private final Cardinality instance_of;
    private final Cardinality usage;
    private final Cardinality source;
    private final Cardinality target;
    private final Cardinality severity;
    private final Cardinality xpath;
    private final Cardinality expression;

    public MetadataPolicy(final Cardinality id,
                          final Cardinality description,
                          final Cardinality title,
                          final Cardinality parent,
                          final Cardinality instance_of,
                          final Cardinality usage,
                          final Cardinality source,
                          final Cardinality target,
                          final Cardinality severity,
                          final Cardinality xpath,
                          final Cardinality expression) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.parent = parent;
        this.instance_of = instance_of;
        this.usage = usage;
        this.source = source;
        this.target = target;
        this.severity = severity;
        this.xpath = xpath;
        this.expression = expression;
    }

    public Cardinality getId() {
        return this.id;
    }

    public Cardinality getDescription() {
        return this.description;
    }

    public Cardinality getTitle() {
        return this.title;
    }

    public Cardinality getParent() {
        return this.parent;
    }

    public Cardinality getInstanceOf() {
        return this.instance_of;
    }

    public Cardinality getUsage() {
        return this.usage;
    }

    public Cardinality getSource() {
        return this.source;
    }

    public Cardinality getTarget() {
        return this.target;
    }

    public Cardinality getSeverity() {
        return this.severity;
    }

    public Cardinality getXpath() {
        return this.xpath;
    }

    public Cardinality getExpression() {
        return this.expression;
    }

    public enum Cardinality {
        REQUIRED,
        OPTIONAL,
        FORBIDDEN
    }
}
