// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

import java.util.EnumMap;

/**
 * The cardinality policy of FSH metadata for a given item type.
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

    private final EnumMap<MetadataType, Cardinality> map;

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
        this.map = new EnumMap<>(MetadataType.class);
        this.map.put(MetadataType.ID, id);
        this.map.put(MetadataType.DESCRIPTION, description);
        this.map.put(MetadataType.TITLE, title);
        this.map.put(MetadataType.PARENT, parent);
        this.map.put(MetadataType.INSTANCE_OF, instance_of);
        this.map.put(MetadataType.USAGE, usage);
        this.map.put(MetadataType.SOURCE, source);
        this.map.put(MetadataType.TARGET, target);
        this.map.put(MetadataType.SEVERITY, severity);
        this.map.put(MetadataType.XPATH, xpath);
        this.map.put(MetadataType.EXPRESSION, expression);
    }

    public Cardinality getCardinality(final MetadataType type) {
        return this.map.get(type);
    }

    public enum Cardinality {
        REQUIRED,
        OPTIONAL,
        FORBIDDEN
    }
}
