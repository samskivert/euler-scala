#!/usr/bin/perl -w

my $number = shift or die "Usage: $0 N\n";
my $url = "http://projecteuler.net/index.php";
printf("<a href=\"$url?section=problems&id=%d\">Problem %03d</a>:\n", $number, $number);
print("<pre>\n");
print(`sed 's:<:\\&lt;:g' Euler$number.scala`);
print("</pre>\n");
