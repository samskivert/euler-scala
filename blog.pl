#!/usr/bin/perl -w

my $number = shift or die "Usage: $0 N\n";
my $url = "http://projecteuler.net/index.php";
printf("<a href=\"$url?section=problems&id=%d\">Problem %03d</a>:\n", $number, $number);
print("<pre>\n");
open(CODE, "Euler$number.scala") or die "Can't read Euler$number.scala: $!\n";
while (<CODE>) {
    $_ =~ s#<#\&lt;#g;
    $_ =~ s#EulerApp#<a href="/code/euler/EulerApp.scala">EulerApp</a>#g;
    print $_;
}
# print(`sed '' Euler$number.scala`);
print("</pre>\n");
