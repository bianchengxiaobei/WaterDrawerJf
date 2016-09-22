package com.waterdrawer.primitive;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import com.waterdrawer.config.ConfigLoadManager;
import com.waterdrawer.config.PrimitiveType;
import com.waterdrawer.config.primitive.SphereConfig;

/**
 * 圆形元件
 * @author Administrator
 *
 */
public class SpherePrimitive extends PrimitiveBase
{
	private float radius;
	private Color fillColor;
	@Override
	public void draw(GraphicsContext gc) 
	{
		gc.setStroke(Color.BLACK);
		gc.strokeOval(0, 0, 30, 30);
	}
	@Override
	public void init() 
	{
		if (this.getM_config() == null)
		{
			this.setM_config(ConfigLoadManager.getInstance().m_mapAllConfig.get(PrimitiveType.Sphere));
			if (this.getM_config() == null)
			{
				System.err.println("元件取得配置文件出错");
			}
		}
		else
		{
			SphereConfig config = (SphereConfig)this.getM_config();
			setRadius(Float.valueOf(config.radius));
			setFillColor(Color.valueOf(config.fillColor));
		}
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}	
}
