package com.waterdrawwer.event;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import org.controlsfx.control.action.Action;

import com.waterdrawer.clientmain.ClientMain;
import com.waterdrawer.util.ResourceUtil;
import com.waterdrawer.util.WDFileUtil;


public class NewProjectAction extends Action
{
	TextInputDialog dlg;
	TextField inputProject;
	CheckBox defalutPathCheckBox;
	public NewProjectAction(String text) 
	{
		super(text);
		setEventHandler(ae -> handle());
	}
	public NewProjectAction(String text,Node image)
	{
		super(text);
		setGraphic(image);
		setEventHandler(ae -> handle());
	}
	private void handle()
	{
		System.out.println("新建工程");
		dlg = new TextInputDialog();
		dlg.setTitle("创建新的工程");
		dlg.getDialogPane().setHeaderText("请输入工程名字");
		Label projectName = new Label("工程名字:");
		inputProject = new TextField();
		HBox pBox = new HBox();
		pBox.getChildren().addAll(projectName,inputProject);
		defalutPathCheckBox = new CheckBox("使用默认的工程路径");
		defalutPathCheckBox.setSelected(true);
		Label locationLable = new Label("路径:");
		TextField inputLocation = new TextField(ClientMain.projectPath);
		Button brownBtn = new Button("浏览");
		HBox hbox = new HBox();
		hbox.getChildren().addAll(locationLable,inputLocation,brownBtn);
		hbox.setDisable(true);
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(pBox,defalutPathCheckBox,hbox);
		dlg.getDialogPane().setContent(vbox);
		dlg.setResultConverter(new Callback<ButtonType, String>() {			
			@Override
			public String call(ButtonType param) {
				if (param == ButtonType.OK)
				{
					createProject();
				}
				return null;
			}
		});
		dlg.initStyle(StageStyle.UTILITY);
		dlg.initOwner(null);
		dlg.show();
	}
	private void createProject()
	{
		if (inputProject.getText() == null || inputProject.getText().isEmpty())
		{
			return;
		}
		if (defalutPathCheckBox.isSelected())
		{
			if (!WDFileUtil.createFileDir(ClientMain.projectPath+"/"+inputProject.getText()))
			{
				System.err.println("创建文件夹出错");
			}
			WDFileUtil.getFileTreeItemRoot().getChildren().add(new TreeItem<String>(inputProject.getText(),ResourceUtil.getImageView("prj_obj.png")));
		}
	}
}
