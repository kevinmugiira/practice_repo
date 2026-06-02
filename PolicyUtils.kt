package org.example



fun isHighPriority(priority: Int): Boolean {
    return priority == 1 || priority == 2
}

fun formatPolicyName(policyName: String): String {
    return "POLICY: ${policyName.uppercase()}"
}

fun main() {

    // Test the isHighPriority function
    println("Priority 1 is high: ${isHighPriority(1)}")
    println("Priority 4 is high: ${isHighPriority(4)}")

    // Test the formatPolicyName function
    println(formatPolicyName("Allow Internal Traffic"))

    // Control flow block for policy statuses
    val policyStatus = "active"

    when (policyStatus) {
        "active" -> println("The policy is currently active.")
        "inactive" -> println("The policy is inactive.")
        "pending" -> println("The policy is pending approval.")
        else -> println("Unknown policy status.")
    }

    // firewall rule list of names
    val firewallRules = listOf(
        "Allow SSH Access",
        "Block External FTP",
        "Enable VPN Traffic",
        "Restrict Guest Network",
        "Allow HTTPS Traffic"
    )

    println("\nFirewall Rules:")
    firewallRules.forEach { rule ->
        println(rule)
    }

    // policies and statuses map
    val policies = mapOf(
        "Internal Access Policy" to "active",
        "Remote Access Policy" to "pending",
        "Legacy Port Policy" to "inactive"
    )

    println("\nPolicies and Statuses:")
    policies.forEach { (policyName, status) ->
        println("$policyName -> $status")
    }
}