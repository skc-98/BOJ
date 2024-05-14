#include<iostream>
#include<unordered_map>
using namespace std;

struct Node {
	Node* left, * right;
	char value;

	Node(char value) {
		this->value = value;
		this->left = nullptr;
		this->right = nullptr;
	}
};

void createTree(unordered_map<char, Node*>& nodes, char parent, char left, char right) {
	if (nodes.find(parent) == nodes.end()) {
		nodes[parent] = new Node(parent);
	}
	if (left != '.') {
		nodes[parent]->left = new Node(left);
		nodes[left] = nodes[parent]->left;
	}
	if (right != '.') {
		nodes[parent]->right = new Node(right);
		nodes[right] = nodes[parent]->right;
	}
}

void preorder(Node* node) {
	if (node == nullptr) return;
	cout << node->value;
	preorder(node->left);
	preorder(node->right);
}

void inorder(Node* node) {
	if (node == nullptr) return;
	inorder(node->left);
	cout << node->value;
	inorder(node->right);
}

void postorder(Node* node) {
	if (node == nullptr) return;
	postorder(node->left);
	postorder(node->right);
	cout << node->value;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	unordered_map<char, Node*> nodemap;
	for (int i = 0; i < n; i++) {
		char a,b,c;
		cin >> a >> b >> c;
		createTree(nodemap, a, b, c);
	}

	if (nodemap.find('A') != nodemap.end()) {
		preorder(nodemap['A']);
		cout << '\n';
		inorder(nodemap['A']);
		cout << '\n';
		postorder(nodemap['A']);
	}

	return 0;
}