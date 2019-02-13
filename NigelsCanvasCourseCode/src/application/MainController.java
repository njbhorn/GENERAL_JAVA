package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.TableCellRenderer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	private static Application mainApplication;
	private String courseNo;
	private String courseCode;
	private String courseTitle;
	private String courseDesc;
//	private Set<Course> courses = new TreeSet<>();
	private ObservableList<Course> courses = FXCollections.observableArrayList();
	private static final String filePathName = "courseInfo.dat";
	File fileName = new File(filePathName);
	private ContextMenu contextMenu = new ContextMenu();

	@FXML
	private TableView<Course> table;

	@FXML
	private TableColumn<Course, String> cNo;

	@FXML
	private TableColumn<Course, String> cCode;

	@FXML
	private TableColumn<Course, String> cTitle;

	@FXML
	private TableColumn<Course, String> cDesc;

	@FXML
	private TextField txtNo;

	@FXML
	private TextField txtCode;

	@FXML
	private TextField txtTitle;

	@FXML
	private TextArea txtDesc;

	@FXML
	private ButtonBar add;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnLoad;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnClose;

	@FXML
	void btnAdd(ActionEvent event) {
		processInputs();
	}

	@FXML
	void btnClose(ActionEvent event) {
		closeApplication();
	}

	@FXML
	void btnDelete(ActionEvent event) {
		deleteCurrentFromTable();
	}
	
    @FXML
    void btnLoad(ActionEvent event) {
    	populateTableFromFile() ;
    }

	@FXML
	void btnSave(ActionEvent event) {
		saveTableToFile();
	}

	@FXML
	private void initialize() {

		populateTableFromFile();

		cNo.setCellValueFactory(cellData -> cellData.getValue().courseNo());
		cCode.setCellValueFactory(cellData -> cellData.getValue().courseCode());
		cTitle.setCellValueFactory(cellData -> cellData.getValue().courseTitle());
		cDesc.setCellValueFactory(cellData -> cellData.getValue().courseDesc());
		table.setItems(courses);
		System.out.println(courses);

		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				updateTextFieldsWithCourseInfo(newSelection);
			}
		});

		MenuItem options = new MenuItem("Clear");
		options.setOnAction(e -> {
			clearTableInfo();
		});

		contextMenu.getItems().add(options);
		table.setOnContextMenuRequested(e -> contextMenu.show(table, e.getScreenX(), e.getScreenY()));
	}

	private void clearTableInfo() {
//		table.getColumns().clear();
		courses.clear();

	}

	private void updateTextFieldsWithCourseInfo(Course courseInfo) {
		txtNo.setText(courseInfo.getCourseNo().toString());
		txtCode.setText(courseInfo.getCourseCode());
		txtTitle.setText(courseInfo.getCourseTitle());
		txtDesc.setText(courseInfo.getCourseDesc());

	}

//	public MainController ( Application app ) {
//		mainApplication = app ;
//	}

	private void populateTableFromFile() {
		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);) {
			String line = br.readLine();
			while (line != null) {
				addCourseToTable(convertReadInfoToCourse(line));
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addCourseToTable(Course course) {
		courses.add(course);

	}

	private void processInputs() {
		getInputs();
		checkInputs();

	}

	private void checkInputs() {
		Course course = createCourse();
		boolean courseExists = doesCourseExist(course);
		if (courseExists) {
			System.out.println("Course Exists...");
		} else {
			// new course so add it to table
			addCourseToTable(course);
		}
	}

	private boolean doesCourseExist(Course course) {

		return false;
	}

	private Course createCourse() {
		return new Course(courseNo, courseCode, courseTitle, courseDesc);
	}

	private void getInputs() {
		courseNo = txtNo.getText();
		courseCode = txtCode.getText();
		courseTitle = txtTitle.getText();
		courseDesc = txtDesc.getText();
	}

	private void saveTableToFile() {

		try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw);) {
			for (Course c : courses) {
				bw.write(convertCourseToReadInfo(c));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Course convertReadInfoToCourse(String line) {
		String[] courseInfo = line.split("\t");
		return new Course(courseInfo);

	}

	private String convertCourseToReadInfo(Course c) {
		StringBuilder courseCode = new StringBuilder();
		addCourseInfoToStringBuilder(courseCode, c.getCourseNo().toString());
		addCourseInfoToStringBuilder(courseCode, c.getCourseCode());
		addCourseInfoToStringBuilder(courseCode, c.getCourseTitle());
		if (c.getCourseDesc().equals(null)) {
			c.setCourseDesc("To Do...");
		}
		addCourseInfoToStringBuilder(courseCode, c.getCourseDesc());
		courseCode.replace(courseCode.length() - 1, courseCode.length(), "\n");
		return courseCode.toString();
	}

	private void addCourseInfoToStringBuilder(StringBuilder sb, String infoToAdd) {
		sb.append(infoToAdd);
		sb.append("\t");
	}

	private void closeApplication() {

		System.exit(0);

	}

	private void deleteCurrentFromTable() {
		deleteRow();

	}

	private void deleteRow() {
		courses.remove(table.getSelectionModel().getSelectedIndex());

	}

}
