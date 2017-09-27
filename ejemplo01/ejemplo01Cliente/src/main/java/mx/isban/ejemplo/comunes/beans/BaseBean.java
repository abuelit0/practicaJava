package mx.isban.ejemplo.comunes.beans;

import java.io.Serializable;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase base de objeto de transferencia de datos
 * @author bonifacio.velazquez
 *
 */
public abstract class BaseBean implements Serializable {

	/**
	 * Clase de ejemplo de uso de la base de los DTO's
	 * @author bonifacio.velazquez
	 */
	@SuppressWarnings("unused")
	private static class ExampleDto extends BaseBean{
		private static final long serialVersionUID = -5098327366276076118L;
		private int id = 0;
		private String name = "";
		
		/**
		 * Hace referencia a la clase padre
		 */
		public ExampleDto(){
			super();
		}	
		
		/**
		 * regresa el ID
		 * @return
		 */
		public int getId() {
			return id;
		}
		
		/**
		 * regresa el nombre
		 * @return
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * asigna el id
		 * @param id
		 */
		public void setId(int id) {
			this.id = id;
		}
		
		/**
		 * asigna el nombre
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
	}

	/**
	 * Id de serializaci&oacute;n gen&eacute;rico
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la base
	 */
	public BaseBean() {
		super();
	}
	
	/**
	 * Metodo para obtener la representaci&oacute;n del objeto en JSON<br/>
	 * La clase que herede BaseDto puede hacer override del metodo
	 * @return JSONWellFormatted Text
	 * @throws Exception Mensaje de error en caso de excepci&oacute;n
	 */
	protected String toJson() throws Exception {
		String val2return = null;
		ObjectMapper mapper = new ObjectMapper();
		val2return = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		return val2return;
	}
	
	/**
	 * Sobre-escritura del metodo de conversion a cadena<br/>
	 * Regresa la representacion en JSON/XML del objeto que lo hereda
	 */
	@Override
	public String toString(){
		String val2return = null;
		try { val2return = this.toJson(); }
		catch(Exception e){
			try { val2return = this.toXml(); }
			catch(Exception E){ }
		}finally {
			if(val2return==null){
				val2return = super.toString();
			}
		}
		return val2return;
	}
	
	/**
	 * Metodo para obtener la representaci&oacute;n del objeto en XML<br/>
	 * La clase que herede BaseDto puede hacer override del metodo
	 * @return XMLWellFormatted Text
	 * @throws Exception Mensaje de error en caso de excepci&oacute;n
	 */
	protected String toXml() throws Exception {
		String val2return = null;
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(this, writer);
		val2return = writer.toString();
		return val2return;
	}
	
	
}
