/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.common

import dev.ohs.fhir.model.r4.Extension

fun List<Extension>.integerOrNull(url: String): Int? =
    firstOrNull { it.url == url }
        ?.value
        ?.asInteger()
        ?.value
        ?.value

fun List<Extension>.stringOrNull(url: String): String? =
    firstOrNull { it.url == url }
        ?.value
        ?.asString()
        ?.value
        ?.value
