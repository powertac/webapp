package edu.kit.iism.experimentcenter

import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.CompareToBuilder
import edu.kit.iism.experimentcenter.enumerations.ShoutType
import edu.kit.iism.experimentcenter.enumerations.ShoutStatus

class BlockShout implements Serializable, Comparable {

  String id
  Experiment experiment
  TradingAgent tradingAgent
  ShoutType shoutType
  ShoutStatus shoutStatus = ShoutStatus.Open
  Date tradingDay
  Double quantityPerTimeslot
  Double limitPrice
  Double averageAllocationPrice
  Long transactionId
  Date dateClosed
  Date dateCreated = new Date()
  Date validUntil = new Date() + 1
  String comment
  SortedSet shouts

  static belongsTo = [experiment: Experiment]

  static hasMany = [shouts: Shout]

  static constraints = {
    experiment(nullable: false)
    tradingAgent(nullable: false)
    shoutType(nullable: false)
    tradingDay(nullable: false)
    shoutStatus(nullable: false)
    quantityPerTimeslot(nullable: false, min: 0d)
    limitPrice(nullable: false, range: 0.0d..3000.0d)
    averageAllocationPrice(nullable: true, range: 0.0d..3000.0d)
    transactionId(nullable: true)
    dateClosed(nullable: true)
    dateCreated(nullable: false)
    validUntil(nullable: true)
    comment(nullable: true)
    shouts(nullable: true)
  }

  static mapping = {
    id generator: 'assigned' 
  }

  public String toString() {
    return id.toString()
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 37).
        append(this.limitPriceExcess).
        append(this.overallQuantity).
        append(this.dateCreated).
        append(this.id).
        toHashCode();
  }

  public boolean equals(Object o) {
    if (!o instanceof BlockShout) return false
    BlockShout other = (BlockShout) o
    return new EqualsBuilder().append(other?.getLimitPriceExcess(), this?.getLimitPriceExcess()).append(other?.getOverallQuantity(), this?.getOverallQuantity()).append(this?.getDateCreated(), other?.getDateCreated()).append(other?.id, this?.id).isEquals()
  }

  public int compareTo(Object o) {
    if (!o instanceof BlockShout) return 1
    BlockShout other = (BlockShout) o
    def cpb = new CompareToBuilder()
    cpb.append(other?.getLimitPriceExcess(), this?.getLimitPriceExcess())
    cpb.append(this?.getOverallQuantity(), other?.getOverallQuantity())
    cpb.append(CalendarUtils.clearMilliseconds(this?.getDateCreated()), CalendarUtils.clearMilliseconds(other?.getDateCreated()))
    cpb.append(other?.id, this?.id)
    return cpb.toComparison();
  }

}
