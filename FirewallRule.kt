package org.example

data class FirewallRule(val protocol: String,
                        val port: Int,
                        val sourceRange: String
)

fun shouldApplyRule(
    sourceIp: String,
    destinationPort: Int,
    protocol: String,
    rules: List<FirewallRule>
): Boolean {

    return rules.any { rule ->
        rule.protocol == protocol &&
                rule.port == destinationPort &&
                (rule.sourceRange == "ANY" || sourceIp.startsWith(rule.sourceRange))
    }
}

fun main() {

    val firewallRules = listOf(

        FirewallRule(
            protocol = "TCP",
            port = 443,
            sourceRange = "192.168"
        ),

        FirewallRule(
            protocol = "UDP",
            port = 53,
            sourceRange = "ANY"
        )
    )

    // TEST CASE 1
    // Happy path: exact match

//    val result1 = shouldApplyRule(
//        sourceIp = "192.168.1.10",
//        destinationPort = 443,
//        protocol = "TCP",
//        rules = firewallRules
//    )
//
//    println("Test Case 1 Result: $result1")


    // TEST CASE 2
    // No matching rule

//    val result2 = shouldApplyRule(
//        sourceIp = "10.0.0.5",
//        destinationPort = 22,
//        protocol = "TCP",
//        rules = firewallRules
//    )
//
//    println("Test Case 2 Result: $result2")


    // TEST CASE 3
    // ANY source range

    val result3 = shouldApplyRule(
        sourceIp = "8.8.8.8",
        destinationPort = 53,
        protocol = "UDP",
        rules = firewallRules
    )

    println("Test Case 3 Result: $result3")
}
