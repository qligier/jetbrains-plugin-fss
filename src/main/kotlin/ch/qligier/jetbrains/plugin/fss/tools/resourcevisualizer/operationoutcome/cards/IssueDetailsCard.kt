/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.cards

import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.OperationOutcomeIssue
import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.OperationOutcomeIssueSeverity
import com.intellij.icons.AllIcons
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.JBFont
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.UIUtil
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane

/**
 * A card to show details about a specific issue.
 **/
class IssueDetailsCard(issue: OperationOutcomeIssue) : JBScrollPane() {
    init {
        border = JBUI.Borders.empty()
        horizontalScrollBarPolicy = HORIZONTAL_SCROLLBAR_NEVER

        val content =
            JPanel().apply {
                layout = BoxLayout(this, BoxLayout.Y_AXIS)
                border = JBUI.Borders.empty(18, 16, 16, 16)
                isOpaque = false

                add(stretchHorizontally(createHeader(issue)))
                add(Box.createVerticalStrut(JBUI.scale(18)))

                if (issue.code != null) {
                    add(JPanel().apply {
                        layout = FlowLayout(FlowLayout.LEFT, 0, 0)
                        alignmentX = LEFT_ALIGNMENT
                        isOpaque = false
                        maximumSize = Dimension(Int.MAX_VALUE, preferredSize.height)
                        add(JLabel().apply {
                            text = issue.code.getCode()
                            font = Font(Font.MONOSPACED, Font.PLAIN, JBUI.scale(14))
                            foreground = JBUI.CurrentTheme.Link.FOCUSED_BORDER_COLOR
                        })
                        val codeDisplay = issue.codeDisplay()
                        if (!codeDisplay.isNullOrBlank()) {
                            add(Box.createHorizontalStrut(JBUI.scale(9)))
                            add(JLabel().apply {
                                text = codeDisplay
                            })
                        }
                    })
                    val codeDefinition = issue.codeDefinition()
                    if (!codeDefinition.isNullOrBlank()) {
                        add(Box.createVerticalStrut(JBUI.scale(4)))
                        add(JLabel().apply {
                            text = codeDefinition
                            font = JBFont.regular().asItalic()
                            alignmentX = LEFT_ALIGNMENT
                        })
                    }
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                }

                add(stretchHorizontally(createSection("Message", createSingleLineField(issue.humanDetails()))))
                add(Box.createVerticalStrut(JBUI.scale(18)))

                if (issue.locations.isNotEmpty()) {
                    val components = issue.locations.map { createSingleLineField(it) }
                    add(stretchHorizontally(createSection("Location", components)))
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                }
                if (issue.expressions.isNotEmpty()) {
                    val components = issue.expressions.map { createSingleLineField(it) }
                    add(stretchHorizontally(createSection("Expression*", components)))
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                }

                val diagnostics = issue.diagnostics ?: "No diagnostics provided"
                add(stretchHorizontally(createSection("Diagnostics", createDiagnosticsField(diagnostics))))

                if (issue.messageId != null) {
                    // Identifies the id of the source message used to construct the actual error message.
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                    add(stretchHorizontally(createSection("Message ID", createSingleLineField(issue.messageId))))
                }

                if (issue.instanceId != null) {
                    // A unique identifier for this particular occurrence of the issue in the source system. This may allow tying a reported issue to a record in the source system's audit log. Included for traceability issues.
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                    add(stretchHorizontally(createSection("Instance ID", createSingleLineField(issue.instanceId))))
                }

                if (issue.issueSource != null) {
                    // Identifies the logical module/software section responsible for identifying the issue. When debugging issues, it's helpful to know where within the logic stack an issue was identified.
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                    add(stretchHorizontally(createSection("Issue source", createSingleLineField(issue.issueSource))))
                }

                if (issue.detectedIssue != null) {
                    // A reference to a stored contraindication that is the basis for this issue. A recipient can expect that the item referenced in this extension is being retained for record keeping purposes.
                    add(Box.createVerticalStrut(JBUI.scale(18)))
                    add(stretchHorizontally(createSection("Detected issue", createSingleLineField(issue.detectedIssue))))
                }

                add(Box.createVerticalGlue())
                alignmentX = LEFT_ALIGNMENT
                maximumSize = Dimension(Int.MAX_VALUE, Int.MAX_VALUE)
            }

        viewport.isOpaque = false
        viewport.background = UIUtil.getPanelBackground()
        setViewportView(content)
    }

    private fun stretchHorizontally(component: JComponent): JComponent {
        component.alignmentX = LEFT_ALIGNMENT
        component.maximumSize = Dimension(Int.MAX_VALUE, component.preferredSize.height)
        component.minimumSize = Dimension(0, component.minimumSize.height)
        return component
    }

    private fun createHeader(issue: OperationOutcomeIssue): JComponent =
        JPanel(BorderLayout()).apply {
            isOpaque = false

            add(
                JLabel("Issue Details").apply {
                    icon = severityHeaderIcon(issue.severity)
                    iconTextGap = JBUI.scale(8)
                    font = JBFont.h2().asBold()
                },
                BorderLayout.WEST,
            )
        }

    private fun createSection(title: String, component: JComponent): JComponent =
        createSection(title, listOf(component))

    private fun createSection(title: String, components: List<JComponent>): JComponent =
        JPanel(BorderLayout(JBUI.scale(0), JBUI.scale(4))).apply {
            isOpaque = false
            add(
                JLabel(title).apply {
                    font = JBFont.label()
                },
                BorderLayout.NORTH,
            )
            components.forEach { add(it, BorderLayout.CENTER) }
        }

    private fun createSingleLineField(text: String, monospace: Boolean = false): JComponent =
        JBTextField(text).apply {
            isEditable = false
            margin = JBUI.insets(1, 4)
            if (monospace) {
                font = Font(Font.MONOSPACED, Font.PLAIN, JBUI.scale(13))
            }
            background = UIUtil.getTextFieldBackground()
            border = BorderFactory.createCompoundBorder(
                JBUI.Borders.customLine(JBUI.CurrentTheme.CustomFrameDecorations.separatorForeground()),
                JBUI.Borders.empty(0, 2),
            )
            maximumSize = Dimension(Int.MAX_VALUE, preferredSize.height)
        }

    private fun createDiagnosticsField(text: String): JComponent {
        val diagnosticsText =
            JBTextArea(text).apply {
                isEditable = false
                lineWrap = false
                wrapStyleWord = false
                rows = 12
                font = Font(Font.MONOSPACED, Font.PLAIN, JBUI.scale(13))
                background = UIUtil.getTextFieldBackground()
                border = JBUI.Borders.empty(10)
            }

        return JBScrollPane(diagnosticsText).apply {
            verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
            border =
                BorderFactory.createCompoundBorder(
                    JBUI.Borders.customLine(JBUI.CurrentTheme.CustomFrameDecorations.separatorForeground()),
                    JBUI.Borders.empty(),
                )
            preferredSize = JBUI.size(640, 230)
            maximumSize = Dimension(Int.MAX_VALUE, JBUI.scale(300))
            alignmentX = LEFT_ALIGNMENT
        }
    }

    private fun severityHeaderIcon(severity: OperationOutcomeIssueSeverity) =
        when (severity) {
            OperationOutcomeIssueSeverity.FATAL,
            OperationOutcomeIssueSeverity.ERROR,
            -> AllIcons.General.Error

            OperationOutcomeIssueSeverity.WARNING -> AllIcons.General.Warning
            OperationOutcomeIssueSeverity.INFORMATION -> AllIcons.General.Information
            OperationOutcomeIssueSeverity.UNKNOWN -> AllIcons.General.Information
        }

}
