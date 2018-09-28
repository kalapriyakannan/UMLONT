package com.ibm.ccl.soa.deploy.saf.ui.handler;

/**
 * Return descriptive information about a potential UIHandler
 * 
 * @since 7.0
 * 
 */
public interface IUIHandlerDescriptor {

	/**
	 * Returns a string corresponding to a implementation, binding, or interface kind. This string
	 * acts as an identifier for a implementation, binding, or interface handler (the handler
	 * registered to process the specified kind).
	 * 
	 * For example, in case of java implementation, getKind() will return 'implementation.java'.
	 * 
	 * @return the QName string of the implementation kind of a component, or the binding kind of an
	 *         reference or service, or an interface kind of an SCA interface
	 */
	public String getKind();

	/**
	 * Returns a name for the component, reference, service, or interface kind. This string is
	 * intended to be suitable for display to an end user.
	 * 
	 * @return the name of the implementation kind of a component, or the binding kind of an external
	 *         service or entry point, or the interface kind of an SCA interface.
	 */
	public String getName();

	/**
	 * Returns text that describes the component, reference, service, or interface kind. This string
	 * is intended to be suitable for display to an end user.
	 * 
	 * @return the description for the implementation kind of a component, or the binding kind of an
	 *         external service or entry point, or the interface kind of an SCA interface
	 */
	public String getDescription();

}
