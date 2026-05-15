/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome

import ch.qligier.jetbrains.plugin.fss.common.integerOrNull
import ch.qligier.jetbrains.plugin.fss.common.stringOrNull
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.OperationOutcome.IssueType.*
import java.util.UUID

data class OperationOutcomeIssue(
    val id: String?,
    val severity: OperationOutcomeIssueSeverity,
    val code: OperationOutcome.IssueType?,
    val details: String?,
    val diagnostics: String?,
    val locations: List<String>,
    val expressions: List<String>,
    // Supported extensions
    val line: Int? = null,
    val column: Int? = null,
    val issueSource: String? = null,
    val detectedIssue: String? = null,
    val messageId: String? = null,
    val instanceId: String? = null,
) {
    companion object {
        // https://hl7.org/fhir/extensions/extensions-OperationOutcome.html
        const val EXT_URL_LINE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line"
        const val EXT_URL_COL = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col"
        const val EXT_URL_ISSUE_SOURCE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source"
        const val EXT_URL_DETECTED_ISSUE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-detectedIssue"
        const val EXT_URL_MESSAGE_ID = "http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id"
        const val EXT_URL_INSTANCE_ID = "http://hl7.org/fhir/StructureDefinition/operationoutcome-instance-id"

        fun from(issue: OperationOutcome.Issue): OperationOutcomeIssue {
            val severity = when (issue.severity.value) {
                OperationOutcome.IssueSeverity.Fatal -> OperationOutcomeIssueSeverity.FATAL
                OperationOutcome.IssueSeverity.Error -> OperationOutcomeIssueSeverity.ERROR
                OperationOutcome.IssueSeverity.Warning -> OperationOutcomeIssueSeverity.WARNING
                OperationOutcome.IssueSeverity.Information -> OperationOutcomeIssueSeverity.INFORMATION
                else -> OperationOutcomeIssueSeverity.UNKNOWN
            }
            return OperationOutcomeIssue(
                id = issue.id,
                severity = severity,
                code = issue.code.value,
                details = issue.details?.text?.value,
                diagnostics = issue.diagnostics?.value,
                locations = issue.location.mapNotNull { it.value },
                expressions = issue.expression.mapNotNull { it.value },
                line = issue.extension.integerOrNull(EXT_URL_LINE),
                column = issue.extension.integerOrNull(EXT_URL_COL),
                issueSource = issue.extension.stringOrNull(EXT_URL_ISSUE_SOURCE),
                detectedIssue = issue.extension.stringOrNull(EXT_URL_DETECTED_ISSUE),
                messageId = issue.extension.stringOrNull(EXT_URL_MESSAGE_ID),
                instanceId = issue.extension.stringOrNull(EXT_URL_INSTANCE_ID),
            )
        }
    }

    val cardKey = UUID.randomUUID().toString()

    fun humanDetails(): String = details ?: diagnostics ?: code?.getCode() ?: "No details provided"

    fun codeDisplay(): String? = code?.getDisplay()

    fun codeDefinition(): String? = when(code) {
        Invalid -> "Content invalid against the specification or a profile."
        Structure -> "A structural issue in the content such as wrong namespace, unable to parse the content completely, invalid syntax, etc."
        Required -> "A required element is missing."
        Value -> "An element or header value is invalid."
        Invariant -> "A content validation rule failed - e.g. a schematron rule."
        Security -> "An authentication/authorization/permissions issue of some kind."
        Login -> "The client needs to initiate an authentication process."
        Unknown -> "The user or system was not able to be authenticated (either there is no process, or the proferred token is unacceptable)."
        Expired -> "User session expired; a login may be required."
        Forbidden -> "The user does not have the rights to perform this action."
        Suppressed -> "Some information was not or might not have been returned due to business rules, consent or privacy rules, or access permission constraints. This information may be accessible through alternate processes."
        Processing -> "Processing issues. These are expected to be final e.g. there is no point resubmitting the same content unchanged."
        Not_Supported -> "The interaction, operation, resource or profile is not supported."
        Duplicate -> "An attempt was made to create a duplicate record."
        Multiple_Matches -> "Multiple matching records were found when the operation required only one match."
        Not_Found -> "The reference provided was not found. In a pure RESTful environment, this would be an HTTP 404 error, but this code may be used where the content is not found further into the application architecture."
        Deleted -> "The reference pointed to content (usually a resource) that has been deleted."
        Too_Long -> "Provided content is too long (typically, this is a denial of service protection type of error)."
        Code_Invalid -> "The code or system could not be understood, or it was not valid in the context of a particular ValueSet.code."
        Extension -> "An extension was found that was not acceptable, could not be resolved, or a modifierExtension was not recognized."
        Too_Costly -> "The operation was stopped to protect server resources; e.g. a request for a value set expansion on all of SNOMED CT."
        Business_Rule -> "The content/operation failed to pass some business rule and so could not proceed."
        Conflict -> "Content could not be accepted because of an edit conflict (i.e. version aware updates). (In a pure RESTful environment, this would be an HTTP 409 error, but this code may be used where the conflict is discovered further into the application architecture.)."
        Transient -> "Transient processing issues. The system receiving the message may be able to resubmit the same content once an underlying issue is resolved."
        Lock_Error -> "A resource/record locking failure (usually in an underlying database)."
        No_Store -> "The persistent store is unavailable; e.g. the database is down for maintenance or similar action, and the interaction or operation cannot be processed."
        Exception -> "An unexpected internal error has occurred."
        Timeout -> "An internal timeout has occurred."
        Incomplete -> "Not all data sources typically accessed could be reached or responded in time, so the returned information might not be complete (applies to search interactions and some operations)."
        Throttled -> "The system is not prepared to handle this request due to load management."
        Informational -> "A message unrelated to the processing success of the completed operation (examples of the latter include things like reminders of password expiry, system maintenance times, etc.)."
        else -> null
    }
}

/**
 * An enumeration representing the severity of an issue in an OperationOutcome resource, plus the unknown value.
 **/
enum class OperationOutcomeIssueSeverity {
    FATAL,
    ERROR,
    WARNING,
    INFORMATION,
    UNKNOWN, // Represents an unknown value that is not part of the standard enumeration
}
