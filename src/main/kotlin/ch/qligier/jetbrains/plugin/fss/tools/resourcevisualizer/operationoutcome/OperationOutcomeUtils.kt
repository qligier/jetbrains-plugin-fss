/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome

internal fun List<OperationOutcomeIssue>.sort(): List<OperationOutcomeIssue> =
    sortedWith(
        compareBy({ it.severity }),
    )

internal fun List<OperationOutcomeIssue>.highestSeverity(): OperationOutcomeIssueSeverity? =
    minByOrNull { it.severity }?.severity
