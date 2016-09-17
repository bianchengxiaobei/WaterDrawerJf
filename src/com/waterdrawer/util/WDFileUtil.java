package com.waterdrawer.util;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.waterdrawer.clientmain.ClientMain;

import javafx.scene.control.TreeItem;
public class WDFileUtil 
{
	private static TreeItem<String> fileTreeRoot = null;
	/**
	 * 创建一个文件夹
	 * */
	public static boolean createFileDir(String fileDirPath)
	{
		if (fileDirPath == null || fileDirPath.isEmpty())
		{
			return false;
		}	
		try {
			File folder = new File(fileDirPath);
			return ((folder.exists() && folder.isDirectory())? true : folder.mkdirs());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 创建文件
	 * */
	public static boolean createFile(String fileName,String fileDir)
	{
		if (createFileDir(fileDir))
		{
			File file = new File(fileDir+"/"+fileName);
			if (!file.exists())
			{
				try {
					return file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 删除文件以及目录
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFolder(String filePath)
	{
		File file = new File(filePath);
		if (!file.exists())
		{
			return false;
		}
		else
		{
			if (file.isFile())
			{
				return deleteFile(filePath);
			}
			else
			{
				return deleteDir(filePath);
			}
		}
	}
	/**
	 * 删除单个文件
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath)
	{
		File file = new File(filePath);
		if (file.exists() && file.isFile())
		{
			file.delete();
			return true;
		}
		return false;
	}
	/**
	 * 删除文件夹
	 * @param path
	 * @return
	 */
	public static boolean deleteDir(String path)
	{
		if (!path.endsWith(File.separator))
		{
			path = path + File.separator;
		}
		File dirFile = new File(path);
		if (!dirFile.exists() || !dirFile.isDirectory())
		{
			return false;
		}
		File[] files = dirFile.listFiles();
		for (File f : files)
		{
			if (f.isFile())
			{
				if (!deleteFile(f.getAbsolutePath()))
				{
					return false;
				}
			}
			else
			{
				if (!deleteDir(f.getAbsolutePath()))
				{
					return false;
				}
			}
		}
		if (dirFile.delete())
		{
			return true;
		}
		return false;
	}
	/**
	 * 重命名文件夹
	 * @param path
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public static boolean renameFolder(String path,String oldName,String newName)
	{
		if (oldName.equals(newName))
		{
			return false;
		}
		File oldFile = new File(path+"/"+oldName);
		File newFile = new File(path+"/"+newName);
		if (!oldFile.exists())
		{
			return false;
		}
		if (newFile.exists())
		{
			System.err.println("重命名的文件已经存在");
		}
		else
		{
			oldFile.renameTo(newFile);
		}
		return true;
	}
	/**
	 * 搜索工程目录取得列表树
	 */
	public static TreeItem<String> scanAllFile(String path)
	{
		TreeItem<String> root = new TreeItem<String>("项目工程");
		Map<File, TreeItem<String>> tempMap = new HashMap<File, TreeItem<String>>();
		root.setExpanded(true);
		File file = new File(path);
		if (file.exists())
		{		
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			for (File f : files)
			{
				if (f.isDirectory())
				{
					list.add(f);
					TreeItem<String> projectItem = new TreeItem<String>(f.getName(),ResourceUtil.getImageView("prj_obj.png"));
					projectItem.setExpanded(true);
					tempMap.put(f, projectItem);
					root.getChildren().add(projectItem);
				}
				else
				{
					if (f.getPath().endsWith(".wd"))
					{
						TreeItem<String> wdItem = new TreeItem<String>(f.getName());
						wdItem.setExpanded(false);
						root.getChildren().add(wdItem);
					}
				}
			}
			File temp;
			while (!list.isEmpty())
			{
				temp = list.removeFirst();
				files = temp.listFiles();
				for (File f2 : files)
				{
					if (f2.isDirectory())
					{
						list.add(f2);
						TreeItem<String> folderItem = new TreeItem<String>(f2.getName());
						folderItem.setExpanded(true);
						tempMap.put(f2, folderItem);
						tempMap.get(temp).getChildren().add(folderItem);
					}
					else
					{
						if (f2.getPath().endsWith(".wd"))
						{
							TreeItem<String> wdItem = new TreeItem<String>(f2.getName(),ResourceUtil.getImageView("file_obj.png"));
							wdItem.setExpanded(false);
							tempMap.get(temp).getChildren().add(wdItem);
						}
					}
				}
			}
		}
		fileTreeRoot = root;
		return root;
	}
	public static TreeItem<String> getFileTreeItemRoot()
	{
		if (WDFileUtil.fileTreeRoot == null)
		{
			fileTreeRoot = scanAllFile(ClientMain.projectPath);
		}
		return fileTreeRoot;		
	}
}
