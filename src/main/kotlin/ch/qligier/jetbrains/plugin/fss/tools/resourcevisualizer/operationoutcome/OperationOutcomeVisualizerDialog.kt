/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome

import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.cards.IssueDetailsCard
import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.cards.MainCard
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.treeStructure.Tree
import com.intellij.util.IconUtil
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.tree.TreeUtil
import dev.ohs.fhir.model.r4.OperationOutcome
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.Component
import javax.swing.Action
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel
import javax.swing.tree.TreeCellRenderer

/**
 * A dialog window that visualizes the content of an [OperationOutcome] resource in a user-friendly way.
 **/
class OperationOutcomeVisualizerDialog(
    project: Project?,
    operationOutcome: OperationOutcome,
) : DialogWrapper(project, true) {
    companion object {
        private const val ICON_SCALE = 1f
        private const val KEY_TABLE = "issueTable"
    }

    private val issues: List<OperationOutcomeIssue> =
        operationOutcome.issue.map { OperationOutcomeIssue.from(it) }.sort()
    private val highestSeverity: OperationOutcomeIssueSeverity? = issues.highestSeverity()
    private val severityIcons: Map<OperationOutcomeIssueSeverity, Icon> = mapOf(
        OperationOutcomeIssueSeverity.FATAL to loadIcon("fatal.svg"),
        OperationOutcomeIssueSeverity.ERROR to loadIcon("error.svg"),
        OperationOutcomeIssueSeverity.WARNING to loadIcon("warning.svg"),
        OperationOutcomeIssueSeverity.INFORMATION to loadIcon("info.svg"),
        OperationOutcomeIssueSeverity.UNKNOWN to loadIcon("unknown.svg"),
    )

    init {
        init()
        title = "Visualization of an OperationOutcome"
    }

    override fun createCenterPanel(): JComponent {
        val root = DefaultMutableTreeNode("OperationOutcome")
        issues.forEach { issue ->
            root.add(DefaultMutableTreeNode(issue))
        }

        val cards = JPanel(CardLayout()).apply {
            add(KEY_TABLE, MainCard(issues, severityIcons))
            issues.forEach { issue ->
                add(issue.cardKey, IssueDetailsCard(issue))
            }
        }

        val tree =
            Tree(DefaultTreeModel(root)).apply {
                isRootVisible = true
                showsRootHandles = true
                cellRenderer = ComplexCellRenderer()
                addTreeSelectionListener { e ->
                    when(TreeUtil.getLastUserObject(e.path)) {
                        is OperationOutcomeIssue -> {
                            val issue = TreeUtil.getLastUserObject(e.path) as OperationOutcomeIssue
                            (cards.layout as CardLayout).show(cards, issue.cardKey)
                        }

                        is String -> {
                            (cards.layout as CardLayout).show(cards, KEY_TABLE)
                        }
                    }
                }
                setSelectionRow(0) // Select the root node by default
            }

        val splitPane =
            JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                JBScrollPane(tree),
                cards,
            ).apply {
                resizeWeight = 0.25
                dividerLocation = 220
            }

        return JPanel(BorderLayout()).apply {
            add(splitPane, BorderLayout.CENTER)
        }
    }

    override fun createSouthPanel(): JComponent =
        panel {
            row {
                label("OperationOutcome with highest severity: ${highestSeverity?.name ?: "no issues"}")
            }
        }

    override fun getDimensionServiceKey(): String = "fss-operation-outcome-visualizer-dialog"

    override fun createActions(): Array<out Action> = arrayOf(okAction)

    private fun loadIcon(filename: String): Icon {
        val originalIcon = IconLoader.getIcon("/icons/operationoutcome/$filename", this::class.java)
        return IconUtil.brighter(IconUtil.scale(originalIcon, null, ICON_SCALE), 0)
    }

    /**
     * This renders the tree nodes for the left panel.
     */
    private inner class ComplexCellRenderer : TreeCellRenderer {
        override fun getTreeCellRendererComponent(
            tree: JTree,
            value: Any,
            selected: Boolean,
            expanded: Boolean,
            leaf: Boolean,
            row: Int,
            hasFocus: Boolean,
        ): Component = when (val userObject: Any? = TreeUtil.getUserObject(value)) {
            is OperationOutcomeIssue -> {
                JLabel(userObject.humanDetails()).apply {
                    icon = severityIcons[userObject.severity]
                    iconTextGap = JBUI.scale(5)
                }
            }

            is String -> {
                JLabel(userObject)
            }

            else -> error("Unsupported user object type: ${userObject?.javaClass?.name ?: "null"}")
        }
    }
}
