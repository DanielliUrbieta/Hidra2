//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.5-2 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: PM.06.04 às 04:13:36 PM AMT 
//


package ledes.hidra.asset;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolutionType }
     * 
     */
    public SolutionType createSolutionType() {
        return new SolutionType();
    }

    /**
     * Create an instance of {@link Asset }
     * 
     */
    public Asset createAsset() {
        return new Asset();
    }

    /**
     * Create an instance of {@link ProfileType }
     * 
     */
    public ProfileType createProfileType() {
        return new ProfileType();
    }

    /**
     * Create an instance of {@link ArtifactType }
     * 
     */
    public ArtifactType createArtifactType() {
        return new ArtifactType();
    }

    /**
     * Create an instance of {@link SolutionType.Artifacts }
     * 
     */
    public SolutionType.Artifacts createSolutionTypeArtifacts() {
        return new SolutionType.Artifacts();
    }

    /**
     * Create an instance of {@link SolutionType.Requirements }
     * 
     */
    public SolutionType.Requirements createSolutionTypeRequirements() {
        return new SolutionType.Requirements();
    }

    /**
     * Create an instance of {@link SolutionType.Design }
     * 
     */
    public SolutionType.Design createSolutionTypeDesign() {
        return new SolutionType.Design();
    }

    /**
     * Create an instance of {@link SolutionType.Implementation }
     * 
     */
    public SolutionType.Implementation createSolutionTypeImplementation() {
        return new SolutionType.Implementation();
    }

    /**
     * Create an instance of {@link SolutionType.Test }
     * 
     */
    public SolutionType.Test createSolutionTypeTest() {
        return new SolutionType.Test();
    }

}
