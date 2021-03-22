module MVCstartProject {
  requires javafx.fxml;
  requires javafx.controls;
  requires javafx.graphics;
  requires java.sql;

  exports view to javafx.graphics, javafx.fxml;
  exports main to javafx.graphics, javafx.fxml;
  opens controller to javafx.fxml;
}