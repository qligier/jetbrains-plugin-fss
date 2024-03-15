// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

import java.util.EnumMap;

/**
 * The cardinality policy of FSH metadata for a given item type.
 *
 * @author Quentin Ligier
 **/
public class KeywordPolicy {

    public static final KeywordPolicy NONE = new KeywordPolicy(Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN);
    public static final KeywordPolicy SSS = new KeywordPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                              Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                              Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                              Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                              Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                              Cardinality.FORBIDDEN);
    public static final KeywordPolicy SSSO = new KeywordPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                               Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN);
    public static final KeywordPolicy SSSR = new KeywordPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                               Cardinality.OPTIONAL, Cardinality.REQUIRED,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN);
    public static final KeywordPolicy SSRO = new KeywordPolicy(Cardinality.FORBIDDEN, Cardinality.OPTIONAL,
                                                               Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                               Cardinality.REQUIRED, Cardinality.OPTIONAL,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN);
    public static final KeywordPolicy RROO = new KeywordPolicy(Cardinality.FORBIDDEN, Cardinality.REQUIRED,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                               Cardinality.REQUIRED, Cardinality.OPTIONAL,
                                                               Cardinality.OPTIONAL);
    public static final KeywordPolicy SSSRR = new KeywordPolicy(Cardinality.OPTIONAL, Cardinality.OPTIONAL,
                                                                Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                Cardinality.REQUIRED, Cardinality.REQUIRED,
                                                                Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
                                                                Cardinality.FORBIDDEN);

    private final EnumMap<KeywordType, Cardinality> map;

    public KeywordPolicy(final Cardinality id,
                         final Cardinality description,
                         final Cardinality title,
                         final Cardinality parent,
                         final Cardinality instanceOf,
                         final Cardinality usage,
                         final Cardinality source,
                         final Cardinality target,
                         final Cardinality severity,
                         final Cardinality xpath,
                         final Cardinality expression) {
        this.map = new EnumMap<>(KeywordType.class);
        this.map.put(KeywordType.ID, id);
        this.map.put(KeywordType.DESCRIPTION, description);
        this.map.put(KeywordType.TITLE, title);
        this.map.put(KeywordType.PARENT, parent);
        this.map.put(KeywordType.INSTANCE_OF, instanceOf);
        this.map.put(KeywordType.USAGE, usage);
        this.map.put(KeywordType.SOURCE, source);
        this.map.put(KeywordType.TARGET, target);
        this.map.put(KeywordType.SEVERITY, severity);
        this.map.put(KeywordType.XPATH, xpath);
        this.map.put(KeywordType.EXPRESSION, expression);
        // Trial Use: Context
        // Trial Use: Characteristics
    }

    public Cardinality getCardinality(final KeywordType type) {
        return this.map.get(type);
    }

    public enum Cardinality {
        REQUIRED,
        OPTIONAL,
        FORBIDDEN
    }
}
