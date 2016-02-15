package com.andreiruse.jdmengine.input.bpmnParser

import com.andreiruse.jdmengine.domain.GraphTask
import com.andreiruse.jdmengine.domain.SequenceFlow
import org.xml.sax.SAXException
import java.io.IOException
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.xpath.XPathFactory

class BpmnParser {

    @Throws(ParserConfigurationException::class, IOException::class, SAXException::class)
    fun parse(bpmnFilePath: String) {
        val document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bpmnFilePath)
        val xPath = XPathFactory.newInstance().newXPath()
        document.documentElement.normalize()
        val rootNode = document.documentElement
        val processNodes = ArrayList<GraphTask>()
        val bpmnNodes = IntProgression.fromClosedRange(0, rootNode.childNodes.length, 1)
                .map { x -> rootNode.childNodes.item(x) }
                .find { x -> "bpmn:process".equals(x?.nodeName) }
                ?.childNodes
        val bpmnNodeCount: Int = bpmnNodes?.length as Int
        val bpmnNodeList = IntProgression.fromClosedRange(0, bpmnNodes?.length as Int, 1).map { x -> bpmnNodes?.item(x) }
        //ToDo Find a generic way to parse all types of elements, and recursively (subprocesses, etc)
        val processEdges = bpmnNodeList.filter { node -> "bpmn:sequenceFlow".equals(node?.nodeName) }.map { edge -> SequenceFlow(edge?.attributes) }
        val processTasks = bpmnNodeList.filter { node -> "bpmn:task".equals(node?.nodeName) }.map { node -> GraphTask(node?.attributes, node?.childNodes) }
        val exclusiveGateways = bpmnNodeList.filter { node -> "bpmn:exclusiveGateway".equals(node?.nodeName) }
        val parallelGateways = bpmnNodeList.filter { node -> "bpmn:parallelGateway".equals(node?.nodeName) }
        val startEvents = bpmnNodeList.filter { node -> "bpmn:startEvent".equals(node?.nodeName) }
        val endEvents = bpmnNodeList.filter { node -> "bpmn:endEvent".equals(node?.nodeName) }
    }

}
