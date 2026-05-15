/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.cards

import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.OperationOutcomeIssue
import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.OperationOutcomeIssueSeverity
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.table.JBTable
import com.intellij.util.ui.JBUI
import java.awt.Component
import java.awt.Font
import javax.swing.Icon
import javax.swing.JTable
import javax.swing.ListSelectionModel
import javax.swing.table.AbstractTableModel
import javax.swing.table.DefaultTableCellRenderer

/**
 * The main card showing a table of issues contained in an [OperationOutcome] resource.
 **/
class MainCard(
    issues: List<OperationOutcomeIssue>,
    private val severityIcons: Map<OperationOutcomeIssueSeverity, Icon>,
) : JBScrollPane() {

    init {
        val tableModel =
            object : AbstractTableModel() {
                override fun getRowCount(): Int = issues.size

                override fun getColumnCount(): Int = 3

                override fun getColumnName(column: Int): String =
                    when (column) {
                        0 -> "Severity"
                        1 -> "Code"
                        2 -> "Details"
                        else -> error("Unsupported column index: $column")
                    }

                override fun getColumnClass(columnIndex: Int): Class<*> =
                    when (columnIndex) {
                        0 -> Icon::class.java
                        1,
                        2,
                            -> String::class.java

                        else -> error("Unsupported column index: $columnIndex")
                    }

                override fun getValueAt(rowIndex: Int, columnIndex: Int): Any {
                    val issue = issues[rowIndex]
                    return when (columnIndex) {
                        0 -> issue.severity ?: error("No icon for severity ${issue.severity}")
                        1 -> issue.code ?: "No code provided"
                        2 -> issue.humanDetails()
                        else -> error("Unsupported column index: $columnIndex")
                    }
                }
            }

        val table =
            JBTable(tableModel).apply {
                fillsViewportHeight = true
                rowHeight = JBUI.scale(24)
                selectionModel.selectionMode = ListSelectionModel.SINGLE_SELECTION

                columnModel.getColumn(0).apply {
                    minWidth = JBUI.scale(36)
                    maxWidth = JBUI.scale(36)
                    preferredWidth = JBUI.scale(36)
                    cellRenderer = SeverityIconCellRenderer()
                }

                columnModel.getColumn(1).cellRenderer = MonospaceTextCellRenderer()
            }

        setViewportView(table)
    }

    private inner class SeverityIconCellRenderer : DefaultTableCellRenderer() {
        init {
            horizontalAlignment = CENTER
        }

        override fun setValue(value: Any?) {
            val severity = value as? OperationOutcomeIssueSeverity ?: error("Unexpected value")
            icon = severityIcons[severity]
            text = ""
            toolTipText = severity.name
        }
    }

    private class MonospaceTextCellRenderer : DefaultTableCellRenderer() {
        override fun getTableCellRendererComponent(
            table: JTable,
            value: Any?,
            isSelected: Boolean,
            hasFocus: Boolean,
            row: Int,
            column: Int,
        ): Component {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column).apply {
                font = Font(Font.MONOSPACED, Font.PLAIN, font.size)
            }
        }
    }
}
