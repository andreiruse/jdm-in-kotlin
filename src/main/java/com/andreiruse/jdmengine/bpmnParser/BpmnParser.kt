package com.andreiruse.jdmengine.bpmnParser

import org.xml.sax.SAXException
import java.io.IOException
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.xpath.XPathFactory

class BpmnParser {

    @Throws(ParserConfigurationException::class, IOException::class, SAXException::class)
    fun parse(bpmnFilePath: String) {
        val document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bpmnFilePath)
        val xPath = XPathFactory.newInstance().newXPath()
        document.documentElement.normalize()
    }

}
