package com.princekr.students.ui;

import com.princekr.students.callback.AddStudentCallback;
import com.princekr.students.callback.RemoveStudentCallback;
import com.princekr.students.model.Student;
import com.princekr.students.service.MainFrameService;
import com.princekr.students.serviceimpl.MainFrameServiceImpl;
import com.princekr.utils.NumberConstants;
import com.princekr.utils.StringConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MainFrame extends JFrame  implements AddStudentCallback, RemoveStudentCallback {

	private MainFrameService mainFrameService;
	private TablePanel tablePanel;
	private StatusPanel statusPanel;
	private AddStudentsForm addStudentsForm;
    private RemoveStudentForm removeStudentForm;
	
	public MainFrame() {
		super(StringConstants.APP_NAME);

		constructAppWindow();
		setJMenuBar(createFrameMenu());
		initializeVariables();
		constructLayout();
		refreshTable();
		setCallbacks();
		
	}

    private void setCallbacks() {
        this.addStudentsForm.setCallback(this);
        this.removeStudentForm.setCallback(this);
    }

    private void refreshTable() {
		List<Student> students = this.mainFrameService.getAllStudents();
		this.tablePanel.setTableModel(students);
		this.tablePanel.updateTable();
	}

	private void constructLayout() {
		setLayout(new BorderLayout());
		add(tablePanel,BorderLayout.CENTER);
		add(statusPanel, BorderLayout.SOUTH);
	}

	private void initializeVariables() {
		this.mainFrameService = new MainFrameServiceImpl();
		this.tablePanel = new TablePanel();
		this.statusPanel = new StatusPanel();
		this.addStudentsForm = new AddStudentsForm(this);
        this.removeStudentForm = new RemoveStudentForm(this);
	}

	private void constructAppWindow() {
		setSize(NumberConstants.APP_WINDOW_SIZE_WIDTH, NumberConstants.APP_WINDOW_SIZE_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	private JMenuBar createFrameMenu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu(StringConstants.MAIN_MENU_FILE);
		JMenuItem openItem = new JMenuItem(StringConstants.MAIN_MENU_OPEN);
		JMenuItem exitItem = new JMenuItem(StringConstants.MAIN_MENU_EXIT);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW);
		JMenuItem addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD);
		JMenuItem removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE);
		windowMenu.add(addItem);
		windowMenu.add(removeItem);


		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentsForm.setVisible(true);

			}
		});

		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                removeStudentForm.setVisible(true);
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(
						MainFrame.this,
						StringConstants.MAIN_MENU_EXIT_TEXT,
						StringConstants.MAIN_MENU_EXIT_TITLE,
						JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					mainFrameService.shutdown();
                    statusPanel.stopTimer();
					System.gc();
					System.exit(0);
				}
			}
		});

		return menuBar;

	}


	public void studentSaved() {
		refreshTable();
        this.removeStudentForm.loadData();
	}

    public void studentRemoved() {
        refreshTable();
        this.removeStudentForm.loadData();
    }
}
