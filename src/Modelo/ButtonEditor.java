package Modelo;

import Controlador.GestionCorrespondencia.controladorAnularCorrespondencia;
import Controlador.GestionCorrespondencia.controladorExterno;
import Controlador.GestionCorrespondencia.controladorInterno;
import Controlador.GestionUsuario.controladorFuncionarios;
import Controlador.GestionUsuario.controladorUsuarios;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private controladorFuncionarios controladorFuncionario;
    private controladorUsuarios controladorUsuario;
    private controladorInterno controladorremitente;
    private controladorExterno controladordestinatario;
    private controladorAnularCorrespondencia controladoranular;

    public ButtonEditor(JCheckBox checkBox, controladorFuncionarios controladorFuncionario) {
        super(checkBox);
        this.controladorFuncionario = controladorFuncionario;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox, controladorUsuarios controladorUsuario) {
        super(checkBox);
        this.controladorUsuario = controladorUsuario;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox, controladorInterno controladorremitente) {
        super(checkBox);
        this.controladorremitente = controladorremitente;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox, controladorExterno controladordestinatario) {
        super(checkBox);
        this.controladordestinatario = controladordestinatario;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    
    
    public ButtonEditor(JCheckBox checkBox, controladorAnularCorrespondencia controladoranular) {
        super(checkBox);
        this.controladoranular = controladoranular;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.table = table;
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {

            int InFila = table.getSelectedRow();
            System.out.println("selecionado "+InFila);
            if (InFila != -1 && button.getText().equals("Editar") && controladorFuncionario != null) {
                controladorFuncionario.modificar();
            } else if (InFila != -1 && button.getText().equals("Editar") && controladorUsuario != null) {
                controladorUsuario.modificar();
            } else if (InFila != -1 && button.getText().equals("Adicionar") && controladorremitente != null) {
                controladorremitente.asignarRemitente();
            } else if (InFila != -1 && button.getText().equals("Adicionar") && controladordestinatario != null) {
                controladordestinatario.asignarRemitente();
            }else if (InFila != -1 && button.getText().equals("Cancelar") && controladoranular != null) {
                controladoranular.cancelarCorrespondencia();
            }

        }
        isPushed = false;
        return new String(label);
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
